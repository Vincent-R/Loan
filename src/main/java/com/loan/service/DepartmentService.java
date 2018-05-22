package com.loan.service;

import com.loan.entity.Department;
import com.loan.model.DepartmentModel;

import java.util.List;

public interface DepartmentService {

    Department save(Department department);

    Department findOneById(int id);

    Department findOneByName(String name);

    List<DepartmentModel> findAllIdName();

    List<Department> findAll();

    int deleteById(int id);
}