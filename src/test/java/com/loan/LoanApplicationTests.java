//package com.loan;
//
//import com.loan.entity.Department;
//import com.loan.entity.Employee;
//import com.loan.service.DepartmentService;
//import com.loan.service.EmployeeService;
//import com.loan.util.TokenSecurity;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.SignatureException;
//import org.activiti.engine.*;
//import org.activiti.engine.history.HistoricProcessInstance;
//import org.activiti.engine.history.HistoricTaskInstance;
//import org.activiti.engine.history.HistoricVariableInstance;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.activiti.engine.task.Task;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LoanApplicationTests {
//	@Autowired
//	ProcessEngine processEngine;
//	@Autowired
//	IdentityService identityService;
//	@Autowired
//	RuntimeService runtimeService;
//	@Autowired
//	TaskService taskService;
//	@Autowired
//	FormService formService;
//	@Autowired
//	HistoryService historyService;
//
//	@Test
//	public void contextLoads() {
//	}
//
//	@Test
//    public void getVariablesTest(){
//        System.out.println(taskService.getVariable("10","loanId").toString());
//    }
//
//	/**
//	 * 启动一个流程实例
//	 */
//	@Test
//	public void start() throws Exception{
//		//设置当前用户
//		//identityService.setAuthenticatedUserId("haha5");
//
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Map<String, Object> variables = new HashMap<>();
////		Calendar ca = Calendar.getInstance();
////		String startDate = sdf.format(ca.getTime());
////		ca.add(Calendar.DAY_OF_MONTH, 2);
//		variables.put("loanId", "qwe1");
//
//		//启动流程并返回流程实例
////        Map<String, Object> variableMap = new HashMap<String, Object>();
////        variableMap.put("name", "activity");
////        processEngine.getFormService().submitStartFormData("s",variables);
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("mortgageLoan", variables);
//		System.out.println("***************启动请假流程完成***************" + processInstance.getId());
//	}
//
//	@Test
//	public void testOne() throws Exception{
//		//部门领导审批通过
//		Task deptLeaderTask = taskService.createTaskQuery().taskCandidateGroup("deptLeader").singleResult();
//		Map<String, String> variablesMap = new HashMap<>();
//		variablesMap.put("deptLeaderApprove", "true");//设置通过审批的标志
//		//完成任务方式一。这里的参数是给下一个Task使用的
//		formService.submitTaskFormData(deptLeaderTask.getId(), variablesMap);
//		//完成任务方式二
//		//taskService.complete(deptLeaderTask.getId(), variablesMap);
//
////        //人事审批通过
////        Task hrTask = taskService.createTaskQuery().taskCandidateGroup("hr").singleResult();
////        variablesMap = new HashMap<String, String>();
////        variablesMap.put("hrApprove", "true");
////        formService.submitTaskFormData(hrTask.getId(), variablesMap);
////
////        //销假
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////        Calendar ca = Calendar.getInstance();
////        Task reportBackTask = taskService.createTaskQuery().taskAssignee(currentUserId).singleResult();
////        variablesMap = new HashMap<String, String>();
////        variablesMap.put("reportBackDate", sdf.format(ca.getTime()));
////        formService.submitTaskFormData(reportBackTask.getId(), variablesMap);
//	}
//
//	/**
//	 * 查询任务
//	 */
//	@Test
//	public void stepOne(){
//		System.out.println("***************stepOne流程开始***************");
//		//查询指定Group的任务
//		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("loanOfficer").list();//receiver的任务
////        List<Task> tasks = taskService.createTaskQuery().taskAssignee("lin").list();//查询安排给特定的人的任务
//		System.out.println(tasks.size());
////        System.out.println(tasks2.size());//指定了kermit，所以gonzo的任务数量为0
//		for (Task task : tasks) {
//			System.out.println("receiver的任务Task Name:" + task.getName() + ",id:" + task.getId());//任务的name与id
//			//System.out.println(task.getAssignee());//任务拥有者
//			System.out.println("流程定义的变量loanId:" + task.getProcessVariables().get("loanId"));
//			System.out.println("流程Id:" + task.getProcessInstanceId());//流程实例id
//            if("15001".equals(task.getProcessInstanceId())){
//                try {
//                    Map<String, Object> map = new HashMap<>();
//                    map.put("approveSuccessful", "true");
//                    taskService.complete(task.getId(), map);
////                    taskService.complete(task.getId());
//                    System.out.println("Task set");
//                }catch (Exception e){
//                    System.out.println("Error");
//                }
//            }
//            if("12507".equals(task.getId())){
//                try {
//                    taskService.claim(task.getId(), "lin2");
//                    System.out.println("Task set");
//                }catch (ActivitiTaskAlreadyClaimedException e){
//                    System.out.println("Error");
//                }
//
//            }
//            System.out.println("Task的任务接收人:" + task.getAssignee());
//			//System.out.println(task.getProcessDefinitionId());//流程定义id
//			//taskService.complete(task.getId());//完成任务
//		}
//
//		System.out.println("receiver的任务数量：" + taskService.createTaskQuery().taskCandidateOrAssigned("lin").count());
//		System.out.println("***************step1流程结束***************");
//
//	}
//
//	/**
//	 * 查询流程
//	 */
//	@Test
//	public void testProcess(){
//		//查询所有的流程
//		List<ProcessInstance> pis = runtimeService.createProcessInstanceQuery().list();
//		for(ProcessInstance pi: pis){
//			System.out.println("流程id:" + pi.getProcessInstanceId());
//			System.out.println("流程定义变量loanId:" + runtimeService.getVariable(pi.getProcessInstanceId(),"loanId") + "hhh" + pi.getProcessVariables().get("loanId"));
//			System.out.println("流程userId:" + runtimeService.getVariable(pi.getProcessInstanceId(),"userId"));
//		}
//
//		//按照流程id查询流程是否走完
////		String processInstanceId = "2501";
////		//去正在执行的任务表查询
////		ProcessInstance pi = runtimeService //表示正在执行的流程实例和执行对象
////				.createProcessInstanceQuery()//创建流程实例查询
////				.processInstanceId(processInstanceId)//使用流程实例ID查询
////				.singleResult();
////		if(pi==null){
////			System.out.println("该流程实例走完");
////		}
////		else{
////			System.out.println("该流程实例还没走完");
////		}
//	}
//
//	/**查询历史流程实例*/
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
////	 * 查询历史任务
////	 */
////	@Test
////	public void findHistoryTask(){
////		String taskAssignee = "receiver";
////		List<HistoricTaskInstance> list = historyService//与历史数据（历史表）相关的Service
////				.createHistoricTaskInstanceQuery()//创建历史任务实例查询
////				.taskCandidateGroup(taskAssignee)//指定历史任务的办理人
////				.list();
////		if(list!=null && list.size()>0){
////			for(HistoricTaskInstance pi:list){
////				System.out.println("流程实例ID:"+pi.getId());//流程实例ID
////				System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID
////				System.out.println("流程名称:"+pi.getName());
////				System.out.println("代理人:"+pi.getAssignee());
////			}
////		}
////	}
//
//	/**
//	 * 查询当前任务
//	 */
//	@Test
//	public void findTask(){
//		System.out.println("Engine Name:"+processEngine.getName());
//		String taskAssignee = "dept";
//		List<Task> list = taskService.createTaskQuery()//创建历史任务实例查询
//				.taskCandidateGroup(taskAssignee)//指定历史任务的办理人
//				.list();
//		if(list!=null && list.size()>0){
//			for(Task task:list){
//				System.out.println("Task实例ID:"+task.getId());//流程实例ID
//				System.out.println("Task定义ID:"+task.getTaskDefinitionKey());//流程定义ID
//				System.out.println("Task名称:"+task.getName());
//				System.out.println("代理人:"+task.getAssignee());
//				System.out.println("请假开始日期:"+taskService.getVariable(task.getId(), "startDate"));
////				System.out.println("请假结束日期:"+taskService.getVariable(task.getId(), "endDate"));
////				System.out.println("请假原因:"+taskService.getVariable(task.getId(), "reason"));
////				System.out.println("人事审批意见:"+taskService.getVariable(task.getId(), "hrApprove"));
//			}
//		}
//	}
//
//	/**
//	 * 设置流程变量
//	 */
//	@Test
//	public void setVariables() {
//		//任务ID
//		String taskId = "2507";
//		//使用基本数据类型设置流程变量
//		taskService.setVariable(taskId, "startDate", "2017-12-27");
//		//使用Javabean类型设置流程变量
//		//User user = new User();
//		//user,setName("hehe");
//		//taskService.setVariable(taskId, "user", user);
//	}
//
//	/**
//	 *获取流程变量
//	 */
//	@Test
//	public void getVariables() {
//		//任务Id
//		String taskId = "2507";
//		/** 1.基本数据类型获取流程变量 */
//		String startDate = (String) taskService.getVariable(taskId, "startDate");
//		/** 2.Javabean类型获取流程变量 */
//		//User u = (User) taskService.getVariable(taskId, "user");
//	}
//
//	/**
//	 * 功能: 模拟设置和获取流程变量.
//	 */
//     @Test
//    public void setAndGetVariables() {
//		/** 设置流程变量 **/
//		//RuntimeService对象可以设置流程变量和获取流程变量
//		// runtimeService.setVariable(executionId, variableName, value);
//		// runtimeService.setVariables(executionId, variables);
//
//		// taskService.setVariable(taskId, variableName, value);
//		// 使用任务Id，和流程变量的名称，设置流程变量的值
//		// taskService.setVariables(taskId, variables);使用任务Id,和Map集合设置流程变量，设置多个值
//
//		// runtimeService.startProcessInstanceByKey(processDefinitionKey,variables);启动流程实例的同时，可以设置流程变量，使用Map集合
//		// taskService.complete(taskId, variables);完成任务的同时，设置流程变量，使用Map集合
//
//		/** 获取流程变量 **/
//		// runtimeService.getVariable(executionId,variableName);使用执行对象Id和流程变量名称，获取值
//		// runtimeService.getVariables(executionId);使用执行对象Id，获取所有的流程变量，返回Map集合
//		// runtimeService.getVariables(executionId,variableNames);使用执行对象Id，获取流程变量的值，通过设置流程变量的名称存放到集合中，获取指定流程变量名称的流程变量的值，值存放到Map中
//
//		// taskService.getVariable(taskId,variableName);使用任务Id和流程变量名称，获取值
//		// taskService.getVariables(taskId);使用任务Id，获取所有的流程变量，返回Map集合
//		// taskService.getVariables(taskId,variableNames);使用任务Id，获取流程变量的值，通过设置流程变量的名称存放到集合中，获取指定流程变量名称的流程变量的值，值存放到Map中
//	 }
//
//	 /**
//	  * 获取历史流程变量
//	  */
//	@Test
//    public void findHistoryProcessVariables() {
//        List<HistoricVariableInstance> list = processEngine.getHistoryService()
//				.createHistoricVariableInstanceQuery() // 创建一个历史的流程变量查询对象
//		        .variableName("请假天数").list();
//		if (null != list && list.size() > 0) {
//			for (HistoricVariableInstance hvi : list) {
//				System.out.println(hvi.getId() + " " + hvi.getProcessInstanceId() + " " + hvi.getVariableName() + "  " + hvi.getVariableTypeName() + "  " + hvi.getValue());
//				System.out.println("###################################");
//			}
//		}
//	}
//
//	@Test
//	public void tokenTest(){
//		//System.out.println(TokenSecurity.createToken(0));
//		try {
//			//TokenSecurity.validateToken("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJoYWhhIiwiaWF0IjoxNTIxNDY0NTc0LCJzdWIiOiJ7bmFtZTpsaW59In0.iGxParJJnwR2fQ32u1X94q9dmWF1knzDbaqb02zZppU");
//		}catch (MalformedJwtException | SignatureException e){
//			System.out.println("无效token");
////			map.put("state","signature");//改造簽名，或者無效的Token
////			map.put("loginAuth","該Token無效");//改造簽名，或者無效的Token
//		}catch (ExpiredJwtException e){
//			System.out.println("过时token");
////			map.put("state","expired");//改造簽名，或者無效的Token
////			map.put("loginAuth","Token已經過時");
//		}catch (Exception e) {
//			e.printStackTrace();
////			map.put("state","fail");
//		}
//	}
//}
