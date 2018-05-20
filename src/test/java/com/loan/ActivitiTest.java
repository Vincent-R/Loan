//package com.loan;
//
//import com.loan.entity.MortgageRecord;
//import com.loan.service.MortgageRecordService;
//import com.loan.util.Constant;
//import org.activiti.engine.HistoryService;
//import org.activiti.engine.ProcessEngine;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.TaskService;
//import org.activiti.engine.history.HistoricProcessInstance;
//import org.activiti.engine.history.HistoricTaskInstance;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.activiti.engine.task.Task;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ActivitiTest {
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private HistoryService historyService;
//
//    @Autowired
//    private MortgageRecordService mortgageRecordService;
//
//    @Autowired
//	private ProcessEngine processEngine;
//
//    @Test
//    public void claimTaskTest(){
//        taskService.claim("77516", "0c5b8e0e3ab34e26817251cbe93907ae");
//    }
//
//    @Test
//	public void startProcess(){
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
//		System.out.println(processInstance.getId());
//	}
//
//	@Test
//	public void getTaskTest(){
//		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(Constant.MORTGAGELOAN).taskAssignee("0c5b8e0e3ab34e26817251cbe93907ae").taskName(Constant.VIEWTASK).list();
//				//.taskCandidateGroup("viewer").list();//所有未安排的面谈任务
//		for (Task task:tasks) {
//			System.out.println(task.getId() + " - " + task.getName());
//			//MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
//		}
//	}
//
//	@Test
//	public void completeTaskTestWithVariable(){
//    	Map<String, Object> map = new HashMap<>();
//    	map.put("charge","yes");
//    	taskService.complete("57504", map);
//	}
//
//	@Test
//	public void completeTaskTest(){
//		taskService.complete("65003");
//	}
//
//    @Test
//    public void getVariableTest(){
//        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("viewer").list();//所有未安排的面谈任务
//        for (Task task:tasks) {
//            System.out.println(taskService.getVariable(task.getId(),"loanId").toString());
//            //MortgageRecord mortgageRecord = mortgageRecordService.findOneById(task.getProcessVariables().get("loanId").toString());
//        }
//    }
//
//	@Test
//	public void deleteProcessTest(){
//    	//删除一个流程实例，参数：流程id，删除原因
//		runtimeService.deleteProcessInstance("50008","hah");
//	}
//
//    @Test
//    public void getNowProcess(){
//        //		//查询所有的流程
//		List<ProcessInstance> pis = runtimeService.createProcessInstanceQuery().list();
//		for(ProcessInstance pi: pis){
//			System.out.println("流程id:" + pi.getProcessInstanceId());
//			System.out.println("流程定义变量loanId:" + runtimeService.getVariable(pi.getProcessInstanceId(),"loanId"));
//		}
//
//		//按照流程id查询流程是否走完
//		String processInstanceId = "2501";
//		//去正在执行的任务表查询
//		ProcessInstance pi = runtimeService //表示正在执行的流程实例和执行对象
//				.createProcessInstanceQuery()//创建流程实例查询
//				.processInstanceId(processInstanceId)//使用流程实例ID查询
//				.singleResult();
//		if(pi==null){
//			System.out.println("该流程实例走完");
//		}
//		else{
//			System.out.println("该流程实例还没走完");
//		}
//    }
//
//    //	/**查询历史流程实例*/
//	@Test
//	public void findHistoryProcessInstance(){
//		//根据流程id查询历史流程
////		String processInstanceId = "1401";
////		HistoricProcessInstance pi = processEngine.getHistoryService()//与历史数据（历史表）相关的Service
////				.createHistoricProcessInstanceQuery()//创建历史流程实例查询
////				.processInstanceId(processInstanceId)//使用流程实例ID查询
////				.singleResult();
////		System.out.println("流程实例ID:"+pi.getId());//流程实例ID
////		System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID
////		System.out.println("流程开始时间:"+pi.getStartTime());
////		System.out.println("流程结束时间:"+pi.getEndTime());
//
//		//查询所有历史流程，正在执行的流程和历史流程都会查到
//		List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery().list();
//		for(HistoricProcessInstance hpi: historicProcessInstances){
//			System.out.println("Initiator:" + hpi.getStartUserId());
//			System.out.println("Process Id:" + hpi.getId());
//			System.out.println("loanId:" + hpi.getProcessVariables().get("loanId"));
//		}
//	}
//
//	/**
//	 * 查询历史任务
//	 */
//	@Test
//	public void findHistoryTask(){
//		String taskAssignee = "receiver";
//		List<HistoricTaskInstance> list = historyService//与历史数据（历史表）相关的Service
//				.createHistoricTaskInstanceQuery()//创建历史任务实例查询
//				.processInstanceId("7508")//taskCandidateGroup(taskAssignee)//指定历史任务的办理人
//				.list();
//		if(list!=null && list.size()>0){
//			for(HistoricTaskInstance task:list){
//				System.out.println("流程实例ID:" + task.getProcessInstanceId());//流程实例ID
//				System.out.println("任务名称:" + task.getName());
//				System.out.println("代理人:" + task.getAssignee());
//			}
//		}
//	}
//}
