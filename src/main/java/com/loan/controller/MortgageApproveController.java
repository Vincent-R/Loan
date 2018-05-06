package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageApprove;
import com.loan.entity.MortgageOrder;
import com.loan.entity.MortgageRecord;
import com.loan.entity.MortgageReport;
import com.loan.service.MortgageApproveService;
import com.loan.service.MortgageOrderService;
import com.loan.service.MortgageRecordService;
import com.loan.service.MortgageReportService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("approve")
public class MortgageApproveController {

    @Autowired
    private MortgageApproveService mortgageApproveService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private MortgageReportService mortgageReportService;

    @Autowired
    private MortgageOrderService mortgageOrderService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/{approveId}", method = RequestMethod.GET)
    public DataReturn<MortgageApprove> getApprove(@PathVariable("approveId") String approveId){
        if("".equals(approveId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "审批表ID不合法" , null);
        }
        MortgageApprove mortgageApprove = mortgageApproveService.findOneById(approveId);
        if(mortgageApprove == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "审批表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageApprove);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> save(@RequestParam(value = "approve", defaultValue = "") String approve,
                                           @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(approve) || "".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageApprove mortgageApprove = null;
        try {
            mortgageApprove = JSON.parseObject(approve, MortgageApprove.class);
            mortgageApprove.setId(UUID.randomUUID().toString().replace("-",""));
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
            MortgageOrder mortgageOrder = mortgageOrderService.findOneById(mortgageRecord.getOrder_id());
            if(mortgageOrder.getReport_type() == Constant.ORDER_REPORT_TYPE_ZHENGPING){
                mortgageApprove.setReport(mortgageOrder.getReport());
            }
            mortgageApprove = mortgageApproveService.save(mortgageApprove);
            mortgageRecord.setApprove_id(mortgageApprove.getId());
            mortgageRecordService.save(mortgageRecord);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加审批表失败", "");
        }
        if(null == mortgageApprove){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加审批表失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加审批表成功", mortgageApprove.getId());
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
