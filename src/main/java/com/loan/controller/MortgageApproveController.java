package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageApprove;
import com.loan.entity.MortgageRecord;
import com.loan.entity.MortgageReport;
import com.loan.service.*;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/approve")
public class MortgageApproveController {

    @Autowired
    private MortgageApproveService mortgageApproveService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private MortgageReportService mortgageReportService;

    @Autowired
    private MortgageCatalogService mortgageCatalogService;

    @Autowired
    private MortgageFormService mortgageFormService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    /**
     * 完成资料收集
     **/
    @ResponseBody
    @RequestMapping(value = "/completeData", method = RequestMethod.POST)
    public DataReturn<String> completeDataCollect(@RequestParam(value = "taskId", defaultValue = "") String taskId,
                                                  @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        try {
            //修改贷款记录
            mortgageRecord.setApprove_data_complete(true);
            mortgageRecord.setApprove_operator(employeeId);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "确认资料收齐失败", "");
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确认资料收齐失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "确认资料收齐成功", mortgageRecord.getId());
    }

    /**
     * 完成报审
     **/
    @ResponseBody
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public DataReturn<String> submit(@RequestParam(value = "time", defaultValue = "") String time,
                                     @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(taskId) || "".equals(time)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date finishTime = null;
        try {
            finishTime = sdf.parse(time);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入时间格式有误", "");
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        if(!mortgageRecord.isApprove_data_complete()){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先确定资料收集完成", "");
        }
        try {
            //修改贷款记录
            mortgageRecord.setApprove_time(finishTime);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "确认报审时间失败", "");
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确认报审时间失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "确认报审时间成功", mortgageRecord.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> saveApprove(@RequestParam(value = "approve", defaultValue = "") String approve,
                                          @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(taskId) || "".equals(approve)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        String loanId = taskService.getVariable(taskId, Constant.LOANID).toString();
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(loanId);
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        if(!mortgageRecord.isApprove_data_complete()){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先确定资料收集完成", "");
        }
        if(null == mortgageRecord.getApprove_time() || "".equals(mortgageRecord.getApprove_time())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先提交审批", "");
        }
        try {
            MortgageApprove mortgageApprove = JSON.parseObject(approve, MortgageApprove.class);
            if(mortgageApprove.getApprove_state() == Constant.APPROVE_PASS){//审批通过
                mortgageApprove.setId(UUID.randomUUID().toString().replace("-",""));
                mortgageApprove.setLoan_id(loanId);
                mortgageApprove = mortgageApproveService.save(mortgageApprove);
                if(null == mortgageApprove){
                    return new DataReturn<>(Constant.RESULT_ERROR, "添加审批信息失败", "");
                }
                mortgageRecord.setApprove_pass(true);
                mortgageRecord.setMortgage_need_guarantee(mortgageApprove.getLoan_condition().isNeed_guarantee());
                mortgageRecord = mortgageRecordService.save(mortgageRecord);
                if(null == mortgageRecord){
                    return new DataReturn<>(Constant.RESULT_ERROR, "修改贷款记录信息失败", "");
                }
            }else if(mortgageApprove.getLater_action() == Constant.APPROVE_ACTION_RETRY){//重新审批
                mortgageRecord.setApprove_data_complete(false);
                mortgageRecord.setApprove_time(null);
                mortgageRecord.setApprove_operator(null);
                mortgageRecord = mortgageRecordService.save(mortgageRecord);
                if(null == mortgageRecord){
                    return new DataReturn<>(Constant.RESULT_ERROR, "修改重新审批信息失败", "");
                }
                Map<String, Object> map = new HashMap<>();
                map.put("approveResult", Constant.APPROVE_RESULT_REAPPLY);
                taskService.complete(taskId, map);
                return new DataReturn<>(Constant.RESULT_OK, "重新审批", "");
            }else if(mortgageApprove.getLater_action() == Constant.APPROVE_ACTION_CHANGEBANK){
                mortgageCatalogService.deleteOneById(mortgageRecord.getCatalog());
                mortgageRecord.setCatalog(null);
                mortgageRecord.setCatalog_operator(null);
                mortgageFormService.deleteOneById(mortgageRecord.getForm());
                mortgageRecord.setForm(null);
                mortgageRecord.setForm_operator(null);
                mortgageRecord.setVisa_finish_time(null);
                mortgageRecord.setVisa_address(null);
                mortgageRecord.setVisa_operator(null);
                mortgageRecord.setOrder_finish_time(null);
                mortgageRecord.setOrder_evaluate_company(null);
                mortgageRecord.setOrder_report_type(Constant.ORDER_REPORT_TYPE_CEPING);
                mortgageReportService.deleteOneById(mortgageRecord.getOrder_report());
                mortgageRecord.setOrder_report(null);
                mortgageRecord.setOrder_operator(null);
                mortgageRecord.setApprove_data_complete(false);
                mortgageRecord.setApprove_time(null);
                mortgageRecord.setApprove_operator(null);
                mortgageRecord.setApprove_zp(null);
                mortgageRecord = mortgageRecordService.save(mortgageRecord);
                if(null == mortgageRecord){
                    return new DataReturn<>(Constant.RESULT_ERROR, "修改换行信息失败", "");
                }
                Map<String, Object> map = new HashMap<>();
                map.put("approveResult", Constant.APPROVE_RESULT_CHANGEBANK);
                taskService.complete(taskId, map);
                return new DataReturn<>(Constant.RESULT_OK, "换行", "");
            }else if(mortgageApprove.getLater_action() == Constant.APPROVE_ACTION_GIVEUP){
                runtimeService.deleteProcessInstance(mortgageRecord.getProcess_id(),"approve");
                mortgageRecord.setRecord_state(Constant.LOANRECORD_ABANDON);
                mortgageRecord = mortgageRecordService.save(mortgageRecord);
                if(null == mortgageRecord){
                    return new DataReturn<>(Constant.RESULT_ERROR, "修改废单信息失败", "");
                }
                return new DataReturn<>(Constant.RESULT_OK, "废单", "");
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定审批状态失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "确定审批状态成功", mortgageRecord.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/report/save", method = RequestMethod.POST)
    public DataReturn<String> saveReport(@RequestParam(value = "report", defaultValue = "") String report,
                                         @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(taskId) || "".equals(report)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        if(!mortgageRecord.isApprove_data_complete()){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先确定资料收集完成", "");
        }
        if(null == mortgageRecord.getApprove_time() || "".equals(mortgageRecord.getApprove_time())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先提交审批", "");
        }
        if(!mortgageRecord.isApprove_pass()){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先填写审批结果", "");
        }
        try {
            MortgageReport mortgageReport = JSON.parseObject(report, MortgageReport.class);
            mortgageReport.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageReport = mortgageReportService.save(mortgageReport);
            if(null == mortgageReport){
                return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
            }
            //修改贷款记录
            mortgageRecord.setApprove_zp(mortgageReport.getId());
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "修改贷款记录信息失败", "");
            }
            //approve task完成
            Map<String, Object> map = new HashMap<>();
            map.put("approveResult", Constant.APPROVE_RESULT_PASS);
            taskService.complete(taskId, map);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加报告成功", mortgageRecord.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    public DataReturn<String> completeApprove(@RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        if(!mortgageRecord.isApprove_data_complete()){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先确定资料收集完成", "");
        }
        if(null == mortgageRecord.getApprove_time() || "".equals(mortgageRecord.getApprove_time())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先提交审批", "");
        }
        if(!mortgageRecord.isApprove_pass()){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先填写审批结果", "");
        }
        if(null == mortgageRecord.getApprove_zp() || "".equals(mortgageRecord.getApprove_zp())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先添加正评", "");
        }
        try {
            //approve task完成
            Map<String, Object> map = new HashMap<>();
            map.put("approveResult", Constant.APPROVE_RESULT_PASS);
            taskService.complete(taskId, map);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "审批未完成", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "审批完成", "");
    }
}
