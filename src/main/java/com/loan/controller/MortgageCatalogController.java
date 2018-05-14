//package com.loan.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.loan.entity.MortgageCatalog;
//import com.loan.entity.MortgageRecord;
//import com.loan.service.MortgageCatalogService;
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
//@RequestMapping("/catalog")
//public class MortgageCatalogController {
//
//    @Autowired
//    private MortgageCatalogService mortgageCatalogService;
//
//    @Autowired
//    private MortgageRecordService mortgageRecordService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @ResponseBody
//    @RequestMapping(value = "/{catalogId}", method = RequestMethod.GET)
//    public DataReturn<MortgageCatalog> getCatalog(@PathVariable("catalogId") String catalogId){
//        if("".equals(catalogId)){
//            return new DataReturn<>(Constant.RESULT_ERROR, "资料目录表ID不合法" , null);
//        }
//        MortgageCatalog mortgageCatalog = mortgageCatalogService.findOneById(catalogId);
//        if(mortgageCatalog == null){
//            return new DataReturn<>(Constant.RESULT_ERROR, "资料目录表不存在" , null);
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageCatalog);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public DataReturn<String> saveCatalog(@RequestParam(value = "catalog", defaultValue = "") String catalog, @RequestParam(value = "taskId", defaultValue = "") String taskId){
//        if("".equals(catalog) || "".equals(taskId)){
//            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
//        }
//        MortgageCatalog mortgageCatalog = null;
//        try {
//            //添加资料目录表
//            mortgageCatalog = JSON.parseObject(catalog, MortgageCatalog.class);
//            mortgageCatalog.setId(UUID.randomUUID().toString().replace("-",""));
//            mortgageCatalog = mortgageCatalogService.save(mortgageCatalog);
//            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId,"loanId").toString());
//            mortgageRecord.setCatalog_id(mortgageCatalog.getId());
//            mortgageRecordService.save(mortgageRecord);
//        }catch (Exception e){
//            return new DataReturn<>(Constant.RESULT_ERROR, "添加资料目录表失败", "");
//        }
//        if(null == mortgageCatalog){
//            return new DataReturn<>(Constant.RESULT_ERROR, "添加资料目录表失败", "");
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "添加资料目录表成功", mortgageCatalog.getId());
//    }
//}
