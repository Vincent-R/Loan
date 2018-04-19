package com.loan.service.serviceImpl;

import com.loan.service.ActivitiService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class ActivitiServiceImpl implements ActivitiService {
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private IdentityService identityService;

    /**
     * 启动一个流程实例
     * @param processInstanceKey
     * @return
     */
    public String startProcessInstance(String processInstanceKey){
        return runtimeService.startProcessInstanceByKey(processInstanceKey).getId();
    }

    /**
     * 启动一个流程实例
     * @param processInstanceKey
     * @param userId
     * @return
     */
    public String startProcessInstance(String processInstanceKey, String userId){
        identityService.setAuthenticatedUserId(userId);
        return runtimeService.startProcessInstanceByKey(processInstanceKey).getId();
    }

    /**
     * 启动一个流程实例
     * @param processInstanceKey
     * @param variables
     * @return
     */
    public String startProcessInstance(String processInstanceKey, Map<String, Object> variables){
        return runtimeService.startProcessInstanceByKey(processInstanceKey, variables).getId();
    }

    /**
     * 启动一个流程实例
     * @param processInstanceKey
     * @param userId
     * @param variables
     * @return
     */
    public String startProcessInstance(String processInstanceKey, String userId, Map<String, Object> variables){
        identityService.setAuthenticatedUserId(userId);
        return runtimeService.startProcessInstanceByKey(processInstanceKey, variables).getId();
    }
}