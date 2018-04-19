package com.loan.service;

import com.loan.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department save(Department department);

    Department findOneById(int id);

    Department findOneByName(String name);

    List<Department> findAll();

    int deleteById(int id);
}