package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageLoan;
import com.loan.entity.MortgageRecord;
import com.loan.service.MortgageLoanService;
import com.loan.service.MortgageRecordService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/loan")
public class MortgageLoanController {

    @Autowired
    private MortgageLoanService mortgageLoanService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/{loanId}", method = RequestMethod.GET)
    public DataReturn<MortgageLoan> getLoan(@PathVariable("loanId") String loanId){
        if("".equals(loanId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "放款表ID不合法" , null);
        }
        MortgageLoan mortgageLoan = mortgageLoanService.findOneById(loanId);
        if(mortgageLoan == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "放款表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageLoan);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> saveLoan(@RequestParam(value = "loan", defaultValue = "") String loan,
                                       @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(loan) || "".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageLoan mortgageLoan = null;
        try {
            mortgageLoan = JSON.parseObject(loan, MortgageLoan.class);
            mortgageLoan.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageLoan = mortgageLoanService.save(mortgageLoan);
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
            mortgageRecord.setLoan_id(mortgageLoan.getId());
            mortgageRecordService.save(mortgageRecord);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加放款表失败", "");
        }
        if(null == mortgageLoan){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加放款表失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加放款表成功", mortgageLoan.getId());
    }
}
