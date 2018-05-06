package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageMortgage;
import com.loan.entity.MortgageRecord;
import com.loan.service.MortgageMortgageService;
import com.loan.service.MortgageRecordService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/mortgage")
public class MortgageMortgageController {

    @Autowired
    private MortgageMortgageService mortgageMortgageService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/{mortgageId}", method = RequestMethod.GET)
    public DataReturn<MortgageMortgage> getMortgage(@PathVariable("mortgageId") String mortgageId){
        if("".equals(mortgageId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "抵押表ID不合法" , null);
        }
        MortgageMortgage mortgageMortgage = mortgageMortgageService.findOneById(mortgageId);
        if(mortgageMortgage == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "抵押表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageMortgage);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> saveMortgage(@RequestParam(value = "mortgage", defaultValue = "") String mortgage,
                                           @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(mortgage) || "".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageMortgage mortgageMortgage = null;
        try {
            mortgageMortgage = JSON.parseObject(mortgage, MortgageMortgage.class);
            mortgageMortgage.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageMortgage = mortgageMortgageService.save(mortgageMortgage);
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
            mortgageRecord.setMortgage_id(mortgageMortgage.getId());
            mortgageRecordService.save(mortgageRecord);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加抵押表失败", "");
        }
        if(null == mortgageMortgage){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加抵押表失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加抵押表成功", mortgageMortgage.getId());
    }
}
