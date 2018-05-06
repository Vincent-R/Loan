package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.*;
import com.loan.returnObj.MObjApprove;
import com.loan.returnObj.MObjCommon;
import com.loan.returnObj.MObjOrder;
import com.loan.service.*;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task/m")
public class MortgageTaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private MortgageCheckListService mortgageCheckListService;

    @Autowired
    private MortgageVisaService mortgageVisaService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MortgageOrderService mortgageOrderService;

    @Autowired
    private MortgageApproveService mortgageApproveService;

    @Autowired
    private MortgageLoanService mortgageLoanService;

    @ResponseBody
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getViewTasks(){
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("viewer").list();//所有未安排的面谈任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            if(null==mortgageRecord.getCatalog_id()||"".equals(mortgageRecord.getCatalog_id())){
                mObjCommon.setState("资料目录表未填写");
            }else if(null==mortgageRecord.getForm_id()||"".equals(mortgageRecord.getForm_id())){
                mObjCommon.setState("个人申请表未填写");
            }else if(null==mortgageRecord.getAdvice_id()||"".equals(mortgageRecord.getAdvice_id())){
                mObjCommon.setState("面谈建议表未填写");
            }else{
                mObjCommon.setState("面谈资料填写完成");
            }
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/view/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getEmployeeViewTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(employeeId).list();//某一业务员的面谈任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            if(null==mortgageRecord.getCatalog_id()||"".equals(mortgageRecord.getCatalog_id())){
                mObjCommon.setState("资料目录表未填写");
            }else if(null==mortgageRecord.getForm_id()||"".equals(mortgageRecord.getForm_id())){
                mObjCommon.setState("个人申请表未填写");
            }else if(null==mortgageRecord.getAdvice_id()||"".equals(mortgageRecord.getAdvice_id())){
                mObjCommon.setState("面谈建议表未填写");
            }else{
                mObjCommon.setState("面谈资料填写完成");
            }
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/visa", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getVisaTasks(){
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("visaOfficer").list();//所有未安排的面签任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            if(null==mortgageRecord.getVisa_id()||"".equals(mortgageRecord.getVisa_id())){
                mObjCommon.setState("待确定签约状态");
            }else{
                mObjCommon.setState("已确定签约状态");
            }
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/visa/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getEmployeeVisaTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("employeeId").list();//某一业务员的面签任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            if(null==mortgageRecord.getVisa_id()||"".equals(mortgageRecord.getVisa_id())){
                mObjCommon.setState("待确定签约状态");
            }else{
                mObjCommon.setState("已确定签约状态");
            }
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public DataReturn<List<MObjOrder>> getOrderTasks(){
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("orderOfficer").list();//所有未安排的下单任务
        List<MObjOrder> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjOrder mObjOrder = new MObjOrder();
            mObjOrder.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjOrder.setName(mortgageCheckList.getClient_name());
            mObjOrder.setPhone(mortgageCheckList.getClient_phone());
            MortgageVisa mortgageVisa = mortgageVisaService.findOneById(mortgageRecord.getVisa_id());
            mObjOrder.setVisa_finish_time(mortgageVisa.getSet_time());
            mObjOrder.setClerk(employeeService.findOneById(mortgageVisa.getOperator()).getName());
            if(null==mortgageRecord.getOrder_id()||"".equals(mortgageRecord.getOrder_id())){
                mObjOrder.setState("待评估下单");
            }else{
                MortgageOrder mortgageOrder = mortgageOrderService.findOneById(mortgageRecord.getOrder_id());
                if(0==mortgageOrder.getOrder_state()){
                    mObjOrder.setState("待评估下单");
                }else if(0==mortgageOrder.getReport_state()){
                    mObjOrder.setState("待出报告");
                }else if(0==mortgageOrder.getReport_type()){
                    mObjOrder.setState("出预评");
                }else{
                    mObjOrder.setState("出正评");
                }
            }
            results.add(mObjOrder);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/order/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjOrder>> getEmployeeOrderTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(employeeId).list();//某一业务员的下单任务
        List<MObjOrder> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjOrder mObjOrder = new MObjOrder();
            mObjOrder.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjOrder.setName(mortgageCheckList.getClient_name());
            mObjOrder.setPhone(mortgageCheckList.getClient_phone());
            MortgageVisa mortgageVisa = mortgageVisaService.findOneById(mortgageRecord.getVisa_id());
            mObjOrder.setVisa_finish_time(mortgageVisa.getSet_time());
            mObjOrder.setClerk(employeeService.findOneById(mortgageVisa.getOperator()).getName());
            if(null==mortgageRecord.getOrder_id()||"".equals(mortgageRecord.getOrder_id())){
                mObjOrder.setState("待评估下单");
            }else{
                MortgageOrder mortgageOrder = mortgageOrderService.findOneById(mortgageRecord.getOrder_id());
                if(0==mortgageOrder.getOrder_state()){
                    mObjOrder.setState("待评估下单");
                }else if(0==mortgageOrder.getReport_state()){
                    mObjOrder.setState("待出报告");
                }else if(0==mortgageOrder.getReport_type()){
                    mObjOrder.setState("出预评");
                }else{
                    mObjOrder.setState("出正评");
                }
            }
            results.add(mObjOrder);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/approve", method = RequestMethod.GET)
    public DataReturn<List<MObjApprove>> getApproveTasks(){
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("approver").list();//所有未安排的审批任务
        List<MObjApprove> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjApprove mObjApprove = new MObjApprove();
            mObjApprove.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjApprove.setName(mortgageCheckList.getClient_name());
            mObjApprove.setPhone(mortgageCheckList.getClient_phone());
            MortgageOrder mortgageOrder = mortgageOrderService.findOneById(mortgageRecord.getOrder_id());
            if(0==mortgageOrder.getReport_type()){
                mObjApprove.setReport_type("预评");
            }else{
                mObjApprove.setReport_type("正评");
            }
            if(null==mortgageRecord.getApprove_id()||"".equals(mortgageRecord.getApprove_id())){
                mObjApprove.setState("资料待收齐");
            }else{
                MortgageApprove mortgageApprove = mortgageApproveService.findOneById(mortgageRecord.getApprove_id());
                if(!mortgageApprove.isHas_data_complete()){
                    mObjApprove.setState("资料待收齐");
                }else if(0==mortgageApprove.getReport_state()){
                    mObjApprove.setState("待出正平");
                }else if(0==mortgageApprove.getSub_branch_state()){
                    mObjApprove.setState("待支行审批");
                }else if(0==mortgageApprove.getBranch_state()){
                    mObjApprove.setState("待分行审批");
                }
            }
            results.add(mObjApprove);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/approve/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjApprove>> getEmployeeApproveTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(employeeId).list();//某一业务员的审批任务
        List<MObjApprove> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjApprove mObjApprove = new MObjApprove();
            mObjApprove.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjApprove.setName(mortgageCheckList.getClient_name());
            mObjApprove.setPhone(mortgageCheckList.getClient_phone());
            MortgageOrder mortgageOrder = mortgageOrderService.findOneById(mortgageRecord.getOrder_id());
            if(0==mortgageOrder.getReport_type()){
                mObjApprove.setReport_type("预评");
            }else{
                mObjApprove.setReport_type("正评");
            }
            if(null==mortgageRecord.getApprove_id()||"".equals(mortgageRecord.getApprove_id())){
                mObjApprove.setState("资料待收齐");
            }else{
                MortgageApprove mortgageApprove = mortgageApproveService.findOneById(mortgageRecord.getApprove_id());
                if(!mortgageApprove.isHas_data_complete()){
                    mObjApprove.setState("资料待收齐");
                }else if(0==mortgageApprove.getReport_state()){
                    mObjApprove.setState("待出正平");
                }else if(0==mortgageApprove.getSub_branch_state()){
                    mObjApprove.setState("待支行审批");
                }else if(0==mortgageApprove.getBranch_state()){
                    mObjApprove.setState("待分行审批");
                }
            }
            results.add(mObjApprove);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/mortgage", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getMortgageTasks(){
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("mortgageOfficer").list();//所有未安排的抵押任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            if(null==mortgageRecord.getMortgage_id()||"".equals(mortgageRecord.getMortgage_id())){
                mObjCommon.setState("待确定抵押状态");
            }else{
                mObjCommon.setState("已确定抵押状态");
            }
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/mortgage/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getEmployeeMortgageTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(employeeId).list();//某一业务员的抵押任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            if(null==mortgageRecord.getMortgage_id()||"".equals(mortgageRecord.getMortgage_id())){
                mObjCommon.setState("待确定抵押状态");
            }else{
                mObjCommon.setState("已确定抵押状态");
            }
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/loan", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getLoanTasks(){
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("loanOfficer").list();//所有未安排的放款任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            if(null==mortgageRecord.getLoan_id()||"".equals(mortgageRecord.getLoan_id())){
                mObjCommon.setState("等待提交担保函与收费明细");
            }else{
                MortgageLoan mortgageLoan = mortgageLoanService.findOneById(mortgageRecord.getLoan_id());
                if(0==mortgageLoan.getGuarantee_state()||0==mortgageLoan.getCharge_a_state()||0==mortgageLoan.getCharge_b_state()||0==mortgageLoan.getCharge_c_state()){
                    mObjCommon.setState("等待提交担保函与收费明细");
                }else {
                    mObjCommon.setState("等待放款");
                }
            }
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "/loan/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getEmployeeLoanTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(employeeId).list();//某一业务员的放款任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist_id());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            if(null==mortgageRecord.getLoan_id()||"".equals(mortgageRecord.getLoan_id())){
                mObjCommon.setState("等待提交担保函与收费明细");
            }else{
                MortgageLoan mortgageLoan = mortgageLoanService.findOneById(mortgageRecord.getLoan_id());
                if(0==mortgageLoan.getGuarantee_state()||0==mortgageLoan.getCharge_a_state()||0==mortgageLoan.getCharge_b_state()||0==mortgageLoan.getCharge_c_state()){
                    mObjCommon.setState("等待提交担保函与收费明细");
                }else {
                    mObjCommon.setState("等待放款");
                }
            }
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ResponseBody
    @RequestMapping(value = "assign", method = RequestMethod.POST)
    public DataReturn<String> setTaskAssignee(@RequestParam(value = "taskId", defaultValue = "") String taskId, @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , "");
        }
        try{
            taskService.claim(taskId, employeeId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "设置失败" , "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "设置成功", "");
    }

    @ResponseBody
    @RequestMapping(value = "complete", method = RequestMethod.POST)
    public DataReturn<String> complete(@RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(taskId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , "");
        }
        try{
            taskService.complete(taskId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "Task设置失败" , "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "Task设置完成" , "");
    }

    @ResponseBody
    @RequestMapping(value = "completeApprove", method = RequestMethod.POST)
    public DataReturn<String> completeApprove(@RequestParam(value = "taskId", defaultValue = "") String taskId, @RequestParam(value = "value", defaultValue = "") String value){
        if("".equals(taskId)||"".equals(value)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , "");
        }
        try{
            Map<String, Object> map = new HashMap<>();
            map.put("approveSuccessful", value);
            taskService.complete(taskId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "Task设置失败" , "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "Task设置完成" , "");
    }
}
