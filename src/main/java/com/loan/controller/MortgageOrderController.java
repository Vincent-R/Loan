//package com.loan.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.loan.entity.MortgageForm;
//import com.loan.entity.MortgageRecord;
//import com.loan.service.MortgageFormService;
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
//@RequestMapping("/form")
//public class MortgageFormController {
//
//    @Autowired
//    private MortgageFormService mortgageFormService;
//
//    @Autowired
//    private MortgageRecordService mortgageRecordService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @ResponseBody
//    @RequestMapping(value = "/{formId}", method = RequestMethod.GET)
//    public DataReturn<MortgageForm> getForm(@PathVariable("formId") String formId){
//        if("".equals(formId)){
//            return new DataReturn<>(Constant.RESULT_ERROR, "个人申请表ID不合法" , null);
//        }
//        MortgageForm mortgageForm = mortgageFormService.findOneById(formId);
//        if(mortgageForm == null){
//            return new DataReturn<>(Constant.RESULT_ERROR, "个人申请表不存在" , null);
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageForm);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public DataReturn<String> saveForm(@RequestParam(value = "form", defaultValue = "") String form, @RequestParam(value = "taskId", defaultValue = "") String taskId){
//        if("".equals(form) || "".equals(taskId)){
//            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
//        }
//        MortgageForm mortgageForm = null;
//        try {
//            //添加个人申请表
//            mortgageForm = JSON.parseObject(form, MortgageForm.class);
//            mortgageForm.setId(UUID.randomUUID().toString().replace("-",""));
//            mortgageForm = mortgageFormService.save(mortgageForm);
//            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
//            mortgageRecord.setForm_id(mortgageForm.getId());
//            mortgageRecordService.save(mortgageRecord);
//        }catch (Exception e){
//            return new DataReturn<>(Constant.RESULT_ERROR, "添加个人申请表失败", "");
//        }
//        if(null == mortgageForm){
//            return new DataReturn<>(Constant.RESULT_ERROR, "添加个人申请表失败", "");
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "添加个人申请表成功", mortgageForm.getId());
//    }
//}
