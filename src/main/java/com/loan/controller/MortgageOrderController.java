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
@RequestMapping("/order")
public class MortgageOrderController {

    @Autowired
    private MortgageOrderService mortgageOrderService;

    @Autowired
    private MortgageReportService mortgageReportService;

    @Autowired
    private MortgageApproveService mortgageApproveService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public DataReturn<MortgageOrder> getOrder(@PathVariable("orderId") String orderId){
        if("".equals(orderId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "订单表ID不合法" , null);
        }
        MortgageOrder mortgageOrder = mortgageOrderService.findOneById(orderId);
        if(mortgageOrder == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "订单表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageOrder);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> saveOrder(@RequestParam(value = "order", defaultValue = "") String order, @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(order) || "".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageOrder mortgageOrder = null;
        try {
            //添加订单下单表
            mortgageOrder = JSON.parseObject(order, MortgageOrder.class);
            mortgageOrder.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageOrder = mortgageOrderService.save(mortgageOrder);
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
            mortgageRecord.setAdvice_id(mortgageOrder.getId());
            mortgageRecordService.save(mortgageRecord);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加订单表失败", "");
        }
        if(null == mortgageOrder){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加订单表失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加订单表成功", mortgageOrder.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/saveReport", method = RequestMethod.POST)
    public DataReturn<String> saveOrderReport(@RequestParam(value = "report", defaultValue = "") String report,
                                              @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                              @RequestParam(value = "state") int state,
                                              @RequestParam(value = "type") int type){
        if("".equals(report) || "".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageReport mortgageReport = null;
        try {
            mortgageReport = JSON.parseObject(report, MortgageReport.class);
            mortgageReport.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageReport = mortgageReportService.save(mortgageReport);
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
            if(mortgageRecord.getOrder_id()==null || "".equals(mortgageRecord.getOrder_id())){
                return new DataReturn<>(Constant.RESULT_ERROR, "请先下单", "");
            }
            MortgageOrder mortgageOrder = mortgageOrderService.findOneById(mortgageRecord.getOrder_id());
            if(mortgageOrder==null){
                return new DataReturn<>(Constant.RESULT_ERROR, "请先下单", "");
            }
            mortgageOrder.setReport_state(state);
            mortgageOrder.setReport_type(type);
            mortgageOrder.setReport(mortgageReport);
            mortgageOrderService.save(mortgageOrder);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
        }
        if(null == mortgageReport){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加报告成功", mortgageReport.getId());
    }
}
