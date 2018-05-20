package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageCatalog;
import com.loan.entity.MortgageCatalogOther;
import com.loan.entity.MortgageForm;
import com.loan.entity.MortgageRecord;
import com.loan.service.MortgageCatalogService;
import com.loan.service.MortgageFormService;
import com.loan.service.MortgageRecordService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/visa")
public class MortgageVisaController {

    @Autowired
    private MortgageCatalogService mortgageCatalogService;

    @Autowired
    private MortgageFormService mortgageFormService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/catalog/{catalogId}", method = RequestMethod.GET)
    public DataReturn<MortgageCatalog> getCatalog(@PathVariable("catalogId") String catalogId){
        if(null == catalogId || "".equals(catalogId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "资料目录表ID不合法" , null);
        }
        MortgageCatalog mortgageCatalog = mortgageCatalogService.findOneById(catalogId);
        if(mortgageCatalog == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "资料目录表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageCatalog);
    }

    @ResponseBody
    @RequestMapping(value = "/catalog/save", method = RequestMethod.POST)
    public DataReturn<String> saveCatalog(@RequestParam(value = "catalog", defaultValue = "") String catalog,
                                          @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                          @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(catalog) || "".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        try {
            //添加资料目录表
            MortgageCatalog mortgageCatalog = JSON.parseObject(catalog, MortgageCatalog.class);
            mortgageCatalog.setId(UUID.randomUUID().toString().replace("-",""));
            //添加额外的资料目录信息
            List<MortgageCatalogOther> mortgageCatalogOthers = mortgageCatalog.getMortgageCatalogOthers();
            for (MortgageCatalogOther mortgageCatalogOther: mortgageCatalogOthers) {
                mortgageCatalogOther.setId(UUID.randomUUID().toString().replace("-",""));
                mortgageCatalogOther.setCatalog(mortgageCatalog.getId());
            }
            mortgageCatalog = mortgageCatalogService.save(mortgageCatalog);
            if(null == mortgageCatalog){
                return new DataReturn<>(Constant.RESULT_ERROR, "添加资料目录表失败", "");
            }
            mortgageRecord.setCatalog(mortgageCatalog.getId());
            mortgageRecord.setCatalog_operator(employeeId);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "修改贷款记录信息失败", "");
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加资料目录表失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加资料目录表成功", mortgageRecord.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/form/{formId}", method = RequestMethod.GET)
    public DataReturn<MortgageForm> getForm(@PathVariable("formId") String formId){
        if(null == formId || "".equals(formId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "个人申请表ID不合法" , null);
        }
        MortgageForm mortgageForm = mortgageFormService.findOneById(formId);
        if(mortgageForm == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "个人申请表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageForm);
    }

    @ResponseBody
    @RequestMapping(value = "/form/save", method = RequestMethod.POST)
    public DataReturn<String> saveForm(@RequestParam(value = "form", defaultValue = "") String form,
                                       @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                       @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(form) || "".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        if(null == mortgageRecord.getCatalog() || "".equals(mortgageRecord.getCatalog())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先添加资料目录表", "");
        }
        try {
            //添加个人申请表
            MortgageForm mortgageForm = JSON.parseObject(form, MortgageForm.class);
            mortgageForm.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageForm = mortgageFormService.save(mortgageForm);
            if(null == mortgageForm){
                return new DataReturn<>(Constant.RESULT_ERROR, "添加个人申请表失败", "");
            }
            //修改贷款记录
            mortgageRecord.setForm(mortgageForm.getId());
            mortgageRecord.setForm_operator(employeeId);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "修改贷款记录信息失败", "");
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加个人申请表失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加个人申请表成功", mortgageRecord.getId());
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> saveVisa(@RequestParam(value = "time", defaultValue = "") String time,
                                       @RequestParam(value = "address", defaultValue = "") String address,
                                       @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                       @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(time) || "".equals(address) || "".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
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
        if(null == mortgageRecord.getCatalog() || "".equals(mortgageRecord.getCatalog())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先添加资料目录表", "");
        }else if(null == mortgageRecord.getForm() || "".equals(mortgageRecord.getForm())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先添加个人申请表", "");
        }
        try {
            //修改贷款记录
            mortgageRecord.setVisa_finish_time(finishTime);
            mortgageRecord.setVisa_address(address);
            mortgageRecord.setVisa_operator(employeeId);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "添加面签信息失败", "");
            }
            //visa task完成
            taskService.complete(taskId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加面签信息失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加面签信息成功", mortgageRecord.getId());
    }
}
