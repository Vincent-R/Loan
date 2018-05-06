package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageRecord;
import com.loan.entity.MortgageVisa;
import com.loan.service.MortgageRecordService;
import com.loan.service.MortgageVisaService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/visa")
public class MortgageVisaController {

    @Autowired
    private MortgageVisaService mortgageVisaService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/{visaId}", method = RequestMethod.GET)
    public DataReturn<MortgageVisa> getVisa(@PathVariable("visaId") String visaId){
        if("".equals(visaId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "面签表ID不合法" , null);
        }
        MortgageVisa mortgageVisa = mortgageVisaService.findOneById(visaId);
        if(mortgageVisa == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "面签表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageVisa);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> saveVisa(@RequestParam(value = "visa", defaultValue = "") String visa, @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(visa) || "".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageVisa mortgageVisa = null;
        try {
            //添加面签建议表
            mortgageVisa = JSON.parseObject(visa, MortgageVisa.class);
            mortgageVisa.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageVisa = mortgageVisaService.save(mortgageVisa);
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
            mortgageRecord.setVisa_id(mortgageVisa.getId());
            mortgageRecordService.save(mortgageRecord);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加面签表失败", "");
        }
        if(null == mortgageVisa){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加面签表失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加面签表成功", mortgageVisa.getId());
    }
}
