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

            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定抵押状态失败", false);
        }
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定抵押状态失败", false);
        }
        return new DataReturn<>(Constant.RESULT_OK, "确定抵押状态成功", false);
    }
}
