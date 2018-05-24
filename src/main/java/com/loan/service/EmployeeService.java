package com.loan.service;

import com.loan.entity.Employee;
import com.loan.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    Employee findOneById(String id);

    Employee findOneByAccount(String account);

    List<Employee> findAll();

    Employee save(Employee employee);

    List<EmployeeModel> findAllIdName(String departmentId);

    int deleteById(String id);
}