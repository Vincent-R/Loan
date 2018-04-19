package com.loan.service;

import com.loan.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findOneById(String id);

    Employee findOneByAccount(String account);

    List<Employee> findAll();

    Employee save(Employee employee);

    int deleteById(String id);
}