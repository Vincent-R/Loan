//package com.loan.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.loan.entity.MortgageAdvice;
//import com.loan.entity.MortgageRecord;
//import com.loan.service.MortgageAdviceService;
//import com.loan.service.MortgageRecordService;
//import com.loan.util.Constant;
//import com.loan.util.DataReturn;
//import org.activiti.engine.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/advice")
//public class MortgageAdviceController {
//
//    @Autowired
//    private MortgageAdviceService mortgageAdviceService;
//
//    @Autowired
//    private MortgageRecordService mortgageRecordService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @ResponseBody
//    @RequestMapping(value = "/{adviceId}", method = RequestMethod.GET)
//    public DataReturn<MortgageAdvice> getAdvice(@PathVariable("adviceId") String adviceId){
//        if("".equals(adviceId)){
//            return new DataReturn<>(Constant.RESULT_ERROR, "面谈建议表ID不合法" , null);
//        }
//        MortgageAdvice mortgageAdvice = mortgageAdviceService.findOneById(adviceId);
//        if(mortgageAdvice == null){
//            return new DataReturn<>(Constant.RESULT_ERROR, "面谈建议表不存在" , null);
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageAdvice);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public DataReturn<String> saveAdvice(@RequestParam(value = "advice", defaultValue = "") String advice, @RequestParam(value = "taskId", defaultValue = "") String taskId){
//        if("".equals(advice) || "".equals(taskId)){
//            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
//        }
//        MortgageAdvice mortgageAdvice = null;
//        try {
//            //添面谈建议表
//            mortgageAdvice = JSON.parseObject(advice, MortgageAdvice.class);
//            mortgageAdvice.setId(UUID.randomUUID().toString().replace("-",""));
//            mortgageAdvice = mortgageAdviceService.save(mortgageAdvice);
//            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
//            mortgageRecord.setAdvice_id(mortgageAdvice.getId());
//            mortgageRecordService.save(mortgageRecord);
//        }catch (Exception e){
//            return new DataReturn<>(Constant.RESULT_ERROR, "添加面谈建议表失败", "");
//        }
//        if(null == mortgageAdvice){
//            return new DataReturn<>(Constant.RESULT_ERROR, "添加面谈建议表失败", "");
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "添加面谈建议表成功", mortgageAdvice.getId());
//    }
//}
