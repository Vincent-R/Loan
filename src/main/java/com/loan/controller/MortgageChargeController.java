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

@RestController
@RequestMapping("/charge")
public class MortgageChargeController {

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public DataReturn<String> confirmChargeTime(@RequestParam(value = "time", defaultValue = "") String time,
                                                @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(time) || "".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , "");
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
        try {
            //修改贷款记录
            mortgageRecord.setCharge_finish_time(finishTime);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "确定收费状态失败", "");
            }
            taskService.complete(taskId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定收费状态失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "确定收费状态成功", mortgageRecord.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/skip", method = RequestMethod.POST)
    public DataReturn<String> skipCharge(@RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , "");
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        try {
            //修改贷款记录
            if(mortgageRecord.isCharge_skip()){
                return new DataReturn<>(Constant.RESULT_ERROR, "已跳过第一次收费", "");
            }
            mortgageRecord.setCharge_skip(true);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "跳过收费失败", "");
            }
            taskService.complete(taskId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "跳过收费失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "跳过收费成功", mortgageRecord.getId());
    }
}
