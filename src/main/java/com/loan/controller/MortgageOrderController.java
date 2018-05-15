package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageForm;
import com.loan.entity.MortgageRecord;
import com.loan.entity.MortgageReport;
import com.loan.service.MortgageFormService;
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
@RequestMapping("/order")
public class MortgageOrderController {

    @Autowired
    private MortgageReportService mortgageReportService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/state/save", method = RequestMethod.POST)
    public DataReturn<String> saveOrderState(@RequestParam(value = "time", defaultValue = "") String time,
                                             @RequestParam(value = "company", defaultValue = "") String company,
                                             @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                             @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(time) || "".equals(company) || "".equals(taskId) || "".equals(employeeId)){
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
            mortgageRecord.setOrder_finish_time(finishTime);
            mortgageRecord.setOrder_evaluate_company(company);
            mortgageRecord.setOrder_operator(employeeId);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定下单状态失败", "");
        }
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定下单状态失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "确定下单状态成功", mortgageRecord.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/report/{reportId}", method = RequestMethod.GET)
    public DataReturn<MortgageReport> getForm(@PathVariable("reportId") String reportId){
        if(null == reportId || "".equals(reportId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "报告ID不合法" , null);
        }
        MortgageReport mortgageReport = mortgageReportService.findOneById(reportId);
        if(mortgageReport == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "报告不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageReport);
    }

    @ResponseBody
    @RequestMapping(value = "/report/save", method = RequestMethod.POST)
    public DataReturn<String> saveReport(@RequestParam(value = "type") int type,
                                         @RequestParam(value = "report", defaultValue = "") String report,
                                         @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                         @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(taskId) || "".equals(report) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageReport mortgageReport = null;
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        if(null == mortgageRecord.getOrder_finish_time() || "".equals(mortgageRecord.getOrder_finish_time())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先确定下单状态", "");
        }
        try {
            mortgageReport = JSON.parseObject(report, MortgageReport.class);
            mortgageReport.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageReport = mortgageReportService.save(mortgageReport);
            //修改贷款记录
            mortgageRecord.setOrder_report_state(Constant.ORDER_REPORT_STATE_COMPLETE);
            mortgageRecord.setOrder_report_type(type);
            mortgageRecord.setOrder_report(mortgageReport.getId());
            if(Constant.ORDER_REPORT_TYPE_ZHENGPING == type){
                mortgageRecord.setApprove_zp(mortgageReport.getId());
            }
            mortgageRecordService.save(mortgageRecord);
            //order task完成
            taskService.complete(taskId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
        }
        if(null == mortgageReport){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加报告成功", mortgageReport.getId());
    }
}
