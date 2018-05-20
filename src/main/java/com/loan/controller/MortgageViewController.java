package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageAdvice;
import com.loan.entity.MortgageRecord;
import com.loan.service.MortgageAdviceService;
import com.loan.service.MortgageRecordService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/view")
public class MortgageViewController {

    @Autowired
    private MortgageAdviceService mortgageAdviceService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @ResponseBody
    @RequestMapping(value = "/{adviceId}", method = RequestMethod.GET)
    public DataReturn<MortgageAdvice> getAdvice(@PathVariable("adviceId") String adviceId){
        if(null == adviceId || "".equals(adviceId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "面谈建议表ID不合法" , null);
        }
        MortgageAdvice mortgageAdvice = mortgageAdviceService.findOneById(adviceId);
        if(mortgageAdvice == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "面谈建议表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageAdvice);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> saveAdvice(@RequestParam(value = "advice", defaultValue = "") String advice,
                                         @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                         @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(advice) || "".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        try {
            //添面谈建议表
            MortgageAdvice mortgageAdvice = JSON.parseObject(advice, MortgageAdvice.class);
            mortgageAdvice.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageAdvice = mortgageAdviceService.save(mortgageAdvice);
            if(null == mortgageAdvice){
                return new DataReturn<>(Constant.RESULT_ERROR, "添加面谈建议表失败", "");
            }
            //设置record
            mortgageRecord.setAdvice(mortgageAdvice.getId());
            mortgageRecord.setAdvice_operator(employeeId);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "修改贷款记录信息失败", "");
            }
            //view task完成
            taskService.complete(taskId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加面谈建议表失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加面谈建议表成功", mortgageRecord.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/suspend", method = RequestMethod.POST)
    public DataReturn<String> suspendRecord(@RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        try {
            runtimeService.deleteProcessInstance(mortgageRecord.getProcess_id(),"order");
            mortgageRecord.setRecord_state(Constant.LOANRECORD_ABANDON);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "修改贷款记录信息失败", "");
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "废单失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "废单成功", mortgageRecord.getId());
    }
}
