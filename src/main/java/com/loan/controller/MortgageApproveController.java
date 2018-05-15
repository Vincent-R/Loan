package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageApprove;
import com.loan.entity.MortgageRecord;
import com.loan.entity.MortgageReport;
import com.loan.service.MortgageApproveService;
import com.loan.service.MortgageRecordService;
import com.loan.service.MortgageReportService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    private TaskService taskService;

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

        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确认资料收齐失败", "");
        }
        if(null == mortgageRecord){
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
            return new DataReturn<>(Constant.RESULT_ERROR, "输入时间有误", "");
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        try {
            //修改贷款记录
            mortgageRecord.setApprove_time(finishTime);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);

        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确认报审时间失败", "");
        }
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "确认报审时间失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "确认报审时间成功", mortgageRecord.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/saveReport", method = RequestMethod.POST)
    public DataReturn<String> saveApproveReport(@RequestParam(value = "report", defaultValue = "") String report,
                                                @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                                @RequestParam(value = "state") int state){
        if("".equals(report) || "".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageReport mortgageReport = null;
        try {
            mortgageReport = JSON.parseObject(report, MortgageReport.class);
            mortgageReport.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageReport = mortgageReportService.save(mortgageReport);
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
            if(mortgageRecord.getApprove_id()==null || "".equals(mortgageRecord.getApprove_id())){
                return new DataReturn<>(Constant.RESULT_ERROR, "请先填写审批进度", "");
            }
            MortgageApprove mortgageApprove = mortgageApproveService.findOneById(mortgageRecord.getApprove_id());
            if(mortgageApprove==null){
                return new DataReturn<>(Constant.RESULT_ERROR, "请先填写审批进度", "");
            }
            mortgageApprove.setReport_state(state);
            mortgageApprove.setReport(mortgageReport);
            mortgageApproveService.save(mortgageApprove);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
        }
        if(null == mortgageReport){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加报告成功", mortgageReport.getId());
    }
}
