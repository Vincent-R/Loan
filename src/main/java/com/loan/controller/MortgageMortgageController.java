package com.loan.controller;

import com.loan.entity.MortgageRecord;
import com.loan.service.MortgageRecordService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mortgage")
public class MortgageMortgageController {

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public DataReturn<Boolean> confirmMortgageState(@RequestParam(value = "time", defaultValue = "") String time,
                                                    @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                                    @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(time) || "".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , false);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date finishTime = null;
        boolean needGuarantee = false;
        try {
            finishTime = sdf.parse(time);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入时间有误", false);
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", false);
        }
        try {
            //修改贷款记录
            mortgageRecord.setMortgage_finish_time(finishTime);
            mortgageRecord.setMortgage_operator(employeeId);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(!mortgageRecord.isMortgage_need_guarantee()){
                needGuarantee = true;
                Map<String, Object> map = new HashMap<>();
                if(mortgageRecord.isCharge_skip()){
                    map.put("charge", Constant.MORTGAGE_CHARGE_NO);
                }else {
                    map.put("charge", Constant.MORTGAGE_CHARGE_YES);
                }
                taskService.complete(taskId, map);
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定抵押状态失败", false);
        }
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定抵押状态失败", false);
        }
        return new DataReturn<>(Constant.RESULT_OK, "确定抵押状态成功", needGuarantee);
    }

    @ResponseBody
    @RequestMapping(value = "/guarantee", method = RequestMethod.POST)
    public DataReturn<String> saveReport(@RequestParam(value = "needStamp") boolean needStamp,
                                         @RequestParam(value = "stampTime", defaultValue = "") String stampTime,
                                         @RequestParam(value = "guaranteeTime", defaultValue = "") String guaranteeTime,
                                         @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(taskId) || (needStamp && "".equals(stampTime)) || "".equals(guaranteeTime)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date stampFinishTime = null;
        Date guaranteeFinishTime = null;
        try {
            stampFinishTime = sdf.parse(stampTime);
            guaranteeFinishTime = sdf.parse(guaranteeTime);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入时间格式有误", "");
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        if(null == mortgageRecord.getMortgage_finish_time() || "".equals(mortgageRecord.getMortgage_finish_time())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先确定抵押状态", "");
        }
        try {
            //修改贷款记录
            mortgageRecord.setMortgage_g_stamp(needStamp);
            mortgageRecord.setMortgage_g_stamp_time(stampFinishTime);
            mortgageRecord.setMortgage_g_time(guaranteeFinishTime);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            //mortgage task完成
            Map<String, Object> map = new HashMap<>();
            if(mortgageRecord.isCharge_skip()){
                map.put("charge", Constant.MORTGAGE_CHARGE_NO);
            }else {
                map.put("charge", Constant.MORTGAGE_CHARGE_YES);
            }
            taskService.complete(taskId, map);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定担保失败", "");
        }
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定担保失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "确定担保成功", mortgageRecord.getId());
    }
}
