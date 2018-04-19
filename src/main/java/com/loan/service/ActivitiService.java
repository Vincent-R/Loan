package com.loan.service;

import java.util.Map;

public interface ActivitiService {

    String startProcessInstance(String processInstanceKey);

    String startProcessInstance(String processInstanceKey, String userId);

    String startProcessInstance(String processInstanceKey, Map<String, Object> variables);

    String startProcessInstance(String processInstanceKey, String userId, Map<String, Object> variables);
}