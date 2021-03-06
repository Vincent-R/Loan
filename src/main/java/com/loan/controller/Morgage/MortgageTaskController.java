package com.loan.controller.Morgage;

import com.loan.dao.LoanMortgageRecordDAO;
import com.loan.dao.MortgageRecordDao;
import com.loan.entity.*;
import com.loan.returnObj.MObjApprove;
import com.loan.returnObj.MObjCommon;
import com.loan.returnObj.MObjOrder;
import com.loan.returnObj.MObjVisa;
import com.loan.service.*;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "抵押贷款任务模块", tags = "抵押贷款任务模块")
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
    private MortgageCatalogOtherService mortgageVisaService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MortgageApproveService mortgageApproveService;

    @Autowired
    private MortgageRecordDao mMortgageRecordDao;

    @Autowired
    private LoanMortgageRecordDAO loanMortgageRecordDAO;


    @ApiOperation(value = "查询所有抵押贷款任务", notes = "查询所有抵押贷款任务")
    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getViewVisaTasks(){
        List<Task> viewTasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.VIEWOFFICER).list();//所有未安排的面谈任务
        List<Task> visaTasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.VISAOFFICER).list();//所有未安排的面签任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task viewTask:viewTasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(viewTask.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(viewTask.getId(), Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
//            mObjCommon.setState("待分配面谈");
            results.add(mObjCommon);
        }
        for (Task visaTask:visaTasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(visaTask.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(visaTask.getId(),Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
//            mObjCommon.setState("待分配面签");
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ApiOperation(value = "【优化】查询所有抵押贷款任务", notes = "【优化】查询所有抵押贷款任务")
    @ResponseBody
    @RequestMapping(value = "/all/v2", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getViewVisaTasksV2(){
        List<Task> viewTasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.VIEWOFFICER).list();//所有未安排的面谈任务
        List<Task> visaTasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.VISAOFFICER).list();//所有未安排的面签任务

        ArrayList<String> ids = new ArrayList<>();

        long startTime=System.currentTimeMillis();   //获取开始时间
        //通过测试，发现时间的消耗还是主要在这个地方啊
        for (Task viewTask:viewTasks) {
            ids.add(taskService.getVariable(viewTask.getId(), Constant.LOANID).toString());
        }

        long endTime=System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        List<MObjCommon> resultList= loanMortgageRecordDAO.queryRecordChecklist(ids);

        return new DataReturn<>(Constant.RESULT_OK, "", resultList);

    }

    @ApiOperation(value = "面谈任务", notes = "面谈任务")
    @ResponseBody
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getViewTasks(){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.VIEWOFFICER).list();//所有未安排的面谈任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(), Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            mObjCommon.setChecklistId(mortgageCheckList.getId());
            mObjCommon.setLoanType(mortgageCheckList.getLoan_type());
//            mObjCommon.setState("待分配面谈");
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ApiOperation(value = "面签任务", tags = "面签任务")
    @ResponseBody
    @RequestMapping(value = "/visa", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getVisaTasks(){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.VISAOFFICER).list();//所有未安排的面签任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(),Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            mObjCommon.setChecklistId(mortgageCheckList.getId());
            mObjCommon.setLoanType(mortgageCheckList.getLoan_type());
//            mObjCommon.setState("待分配面签");
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ApiOperation(value = "通过员工id查看面谈任务", notes = "通过员工id查看面谈任务")
    @ResponseBody
    @RequestMapping(value = "/view/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getEmployeeViewTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskAssignee(employeeId).taskName(Constant.VIEWTASK).list();//某一业务员的面谈任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(),Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            mObjCommon.setChecklistId(mortgageCheckList.getId());
            mObjCommon.setLoanType(mortgageCheckList.getLoan_type());
//            mObjCommon.setState("待填写面谈建议");
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ApiOperation(value = "通过员工id查看面签任务", notes = "通过员工id查看面签任务")
    @ResponseBody
    @RequestMapping(value = "/visa/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjVisa>> getEmployeeVisaTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskAssignee(employeeId).taskName(Constant.VISATASK).list();//某一业务员的面签任务
        List<MObjVisa> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjVisa mObjVisa = new MObjVisa();
            mObjVisa.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(),Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjVisa.setName(mortgageCheckList.getClient_name());
            mObjVisa.setPhone(mortgageCheckList.getClient_phone());
            mObjVisa.setLoan_type(mortgageCheckList.getLoan_type());
            if(null==mortgageRecord.getCatalog()||"".equals(mortgageRecord.getCatalog())){
                mObjVisa.setState("待填写资料目录表");
            }else if(null==mortgageRecord.getForm()||"".equals(mortgageRecord.getForm())){
                mObjVisa.setState("待填写个人申请表");
            }else{
                mObjVisa.setState("待确定签约状态");
            }
            results.add(mObjVisa);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

//    @ResponseBody
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public DataReturn<List<MObjOrder>> getOrderTasks(){
//        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.ORDEROFFICER).list();//所有未安排的下单任务
//        List<MObjOrder> results = new ArrayList<>();
//        for (Task task:tasks) {
//            MObjOrder mObjOrder = new MObjOrder();
//            mObjOrder.setTaskId(task.getId());
//            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(),Constant.LOANID).toString());
//            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
//            mObjOrder.setName(mortgageCheckList.getClient_name());
//            mObjOrder.setPhone(mortgageCheckList.getClient_phone());
//            mObjOrder.setVisa_finish_time(mortgageRecord.getVisa_finish_time());
//            mObjOrder.setClerk(employeeService.findOneById(mortgageRecord.getVisa_operator()).getName());
//            if(null==mortgageRecord.getOrder_finish_time()||"".equals(mortgageRecord.getOrder_finish_time())){
//                mObjOrder.setState("待评估下单");
//            }else{
//                mObjOrder.setState("待出报告");
//            }
//            results.add(mObjOrder);
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "", results);
//    }

    @ApiOperation(value = "通过员工id查看评估下单任务", notes = "通过员工id查看评估下单任务")
    @ResponseBody
    @RequestMapping(value = "/order/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjOrder>> getEmployeeOrderTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskAssignee(employeeId).taskName(Constant.ORDERTASK).list();//某一业务员的下单任务
        List<MObjOrder> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjOrder mObjOrder = new MObjOrder();
            mObjOrder.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(),Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjOrder.setName(mortgageCheckList.getClient_name());
            mObjOrder.setPhone(mortgageCheckList.getClient_phone());
            mObjOrder.setVisa_finish_time(mortgageRecord.getVisa_finish_time());
            mObjOrder.setClerk(employeeService.findOneById(mortgageRecord.getVisa_operator()).getName());
            if(null==mortgageRecord.getOrder_finish_time()||"".equals(mortgageRecord.getOrder_finish_time())){
                mObjOrder.setState("待评估下单");
            }else{
                mObjOrder.setState("待出报告");
            }
            results.add(mObjOrder);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

//    @ResponseBody
//    @RequestMapping(value = "/approve", method = RequestMethod.GET)
//    public DataReturn<List<MObjApprove>> getApproveTasks(){
//        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.APPROVEOFFICER).list();//所有未安排的审批任务
//        List<MObjApprove> results = new ArrayList<>();
//        for (Task task:tasks) {
//            MObjApprove mObjApprove = new MObjApprove();
//            mObjApprove.setTaskId(task.getId());
//            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(), Constant.LOANID).toString());
//            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
//            mObjApprove.setName(mortgageCheckList.getClient_name());
//            mObjApprove.setPhone(mortgageCheckList.getClient_phone());
//            if(null == mortgageRecord.getApprove_zp_finish_time() || "".equals(mortgageRecord.getApprove_zp_finish_time())){
//                mObjApprove.setReport_type("预评");
//            }else{
//                mObjApprove.setReport_type("正评");
//            }
//            if(!mortgageRecord.isApprove_data_complete()){
//                mObjApprove.setState("待确定资料目录表");
//            }else if(null==mortgageRecord.getApprove_time()||"".equals(mortgageRecord.getApprove_time())) {
//                mObjApprove.setState("待报审");
//            }else if(!mortgageRecord.isApprove_pass()) {
//                mObjApprove.setState("待确定审批状态");
//            }else{
//                mObjApprove.setState("待出正评");
//            }
//            results.add(mObjApprove);
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "", results);
//    }

    @ApiOperation(value = "通过员工id查看审批任务", notes = "通过员工id查看审批任务")
    @ResponseBody
    @RequestMapping(value = "/approve/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjApprove>> getEmployeeApproveTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskAssignee(employeeId).taskName(Constant.APPROVETASK).list();//某一业务员的审批任务
        List<MObjApprove> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjApprove mObjApprove = new MObjApprove();
            mObjApprove.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(), Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjApprove.setName(mortgageCheckList.getClient_name());
            mObjApprove.setPhone(mortgageCheckList.getClient_phone());
            if(null == mortgageRecord.getApprove_zp_finish_time() || "".equals(mortgageRecord.getApprove_zp_finish_time())){
                mObjApprove.setReport_type("预评");
            }else{
                mObjApprove.setReport_type("正评");
            }
            if(!mortgageRecord.isApprove_data_complete()){
                mObjApprove.setState("待确定资料目录表");
            }else if(null==mortgageRecord.getApprove_time()||"".equals(mortgageRecord.getApprove_time())) {
                mObjApprove.setState("待报审");
            }else if(!mortgageRecord.isApprove_pass()) {
                mObjApprove.setState("待确定审批状态");
            }else{
                mObjApprove.setState("待出正评");
            }
            results.add(mObjApprove);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

//    @ResponseBody
//    @RequestMapping(value = "/mortgage", method = RequestMethod.GET)
//    public DataReturn<List<MObjCommon>> getMortgageTasks(){
//        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.MORTGAGEOFFICER).list();//所有未安排的抵押任务
//        List<MObjCommon> results = new ArrayList<>();
//        for (Task task:tasks) {
//            MObjCommon mObjCommon = new MObjCommon();
//            mObjCommon.setTaskId(task.getId());
//            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(),Constant.LOANID).toString());
//            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
//            mObjCommon.setName(mortgageCheckList.getClient_name());
//            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
//            if(null==mortgageRecord.getMortgage_finish_time()||"".equals(mortgageRecord.getMortgage_finish_time())){
//                mObjCommon.setState("待确定抵押状态");
//            }else if(mortgageRecord.isMortgage_need_guarantee() &&(null==mortgageRecord.getMortgage_g_time()||"".equals(mortgageRecord.getMortgage_g_time()))){
//                mObjCommon.setState("待出具担保函");
//            }
//            results.add(mObjCommon);
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "", results);
//    }

    @ApiOperation(value = "通过员工id查看抵押任务", notes = "通过员工id查看抵押任务")
    @ResponseBody
    @RequestMapping(value = "/mortgage/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getEmployeeMortgageTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskAssignee(employeeId).taskName(Constant.MORTGAGETASK).list();//某一业务员的抵押任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(),Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            if(null==mortgageRecord.getMortgage_finish_time()||"".equals(mortgageRecord.getMortgage_finish_time())){
//                mObjCommon.setState("待确定抵押状态");
            }else if(mortgageRecord.isMortgage_need_guarantee() &&(null==mortgageRecord.getMortgage_g_time()||"".equals(mortgageRecord.getMortgage_g_time()))){
//                mObjCommon.setState("待出具担保函");
            }
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

//    @ResponseBody
//    @RequestMapping(value = "/charge", method = RequestMethod.GET)
//    public DataReturn<List<MObjCommon>> getChargeTasks(){
//        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.CHARGEOFFICER).list();//所有未安排的收费任务
//        List<MObjCommon> results = new ArrayList<>();
//        for (Task task:tasks) {
//            MObjCommon mObjCommon = new MObjCommon();
//            mObjCommon.setTaskId(task.getId());
//            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(), Constant.LOANID).toString());
//            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
//            mObjCommon.setName(mortgageCheckList.getClient_name());
//            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
//            mObjCommon.setState("待确定收费状态");
//            results.add(mObjCommon);
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "", results);
//    }

    @ApiOperation(value = "通过员工id查看收费任务", notes = "通过员工id查看收费任务")
    @ResponseBody
    @RequestMapping(value = "/charge/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getEmployeeChargeTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskAssignee(employeeId).taskName(Constant.CHARGETASK).list();//某一业务员的收费任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(), Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            mObjCommon.setChecklistId(mortgageCheckList.getId());
            mObjCommon.setLoanType(mortgageCheckList.getLoan_type());
//            mObjCommon.setState("待确定收费状态");
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

//    @ResponseBody
//    @RequestMapping(value = "/loan", method = RequestMethod.GET)
//    public DataReturn<List<MObjCommon>> getLoanTasks(){
//        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskCandidateGroup(Constant.LOANOFFICER).list();//所有未安排的放款任务
//        List<MObjCommon> results = new ArrayList<>();
//        for (Task task:tasks) {
//            MObjCommon mObjCommon = new MObjCommon();
//            mObjCommon.setTaskId(task.getId());
//            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(), Constant.LOANID).toString());
//            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
//            mObjCommon.setName(mortgageCheckList.getClient_name());
//            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
//            mObjCommon.setState("等待放款");
//            results.add(mObjCommon);
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "", results);
//    }

    @ApiOperation(value = "通过员工id查看贷款任务", notes = "通过员工id查看评估贷款任务")
    @ResponseBody
    @RequestMapping(value = "/loan/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getEmployeeLoanTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskAssignee(employeeId).taskName(Constant.LOANTASK).list();//某一业务员的放款任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(), Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            mObjCommon.setChecklistId(mortgageCheckList.getId());
            mObjCommon.setLoanType(mortgageCheckList.getLoan_type());
//            mObjCommon.setState("等待放款");
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ApiOperation(value = "根据员工ID查看任务", notes = "根据员工ID查看任务")
    @ResponseBody
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public DataReturn<List<MObjCommon>> getEmployeeAllTasks(@PathVariable("employeeId") String employeeId){
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskAssignee(employeeId).list();//某一业务员的所有任务
        List<MObjCommon> results = new ArrayList<>();
        for (Task task:tasks) {
            MObjCommon mObjCommon = new MObjCommon();
            mObjCommon.setTaskId(task.getId());
            MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(task.getId(), Constant.LOANID).toString());
            MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(mortgageRecord.getChecklist());
            mObjCommon.setName(mortgageCheckList.getClient_name());
            mObjCommon.setPhone(mortgageCheckList.getClient_phone());
            mObjCommon.setChecklistId(mortgageCheckList.getId());
//            mObjCommon.setState("");
            results.add(mObjCommon);
        }
        return new DataReturn<>(Constant.RESULT_OK, "", results);
    }

    @ApiOperation(value = "分配任务给员工", notes = "分配任务给员工")
    @ResponseBody
    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public DataReturn<String> setTaskAssignee(@RequestParam(value = "taskId", defaultValue = "") String taskId,
                                              @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , "");
        }
        try{
            taskService.claim(taskId, employeeId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "任务分配失败" , "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "任务分配成功", "");
    }

//    @ResponseBody
//    @RequestMapping(value = "/complete", method = RequestMethod.POST)
//    public DataReturn<String> complete(@RequestParam(value = "taskId", defaultValue = "") String taskId){
//        if("".equals(taskId)){
//            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , "");
//        }
//        try{
//            taskService.complete(taskId);
//        }catch (Exception e){
//            return new DataReturn<>(Constant.RESULT_ERROR, "Task设置失败" , "");
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "Task设置完成" , "");
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/completeApprove", method = RequestMethod.POST)
//    public DataReturn<String> completeApprove(@RequestParam(value = "taskId", defaultValue = "") String taskId, @RequestParam(value = "value", defaultValue = "") String value){
//        if("".equals(taskId)||"".equals(value)){
//            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , "");
//        }
//        try{
//            Map<String, Object> map = new HashMap<>();
//            map.put("approveSuccessful", value);
//            taskService.complete(taskId);
//        }catch (Exception e){
//            return new DataReturn<>(Constant.RESULT_ERROR, "Task设置失败" , "");
//        }
//        return new DataReturn<>(Constant.RESULT_OK, "Task设置完成" , "");
//    }
}
