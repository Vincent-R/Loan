package com.loan.dao;

import com.loan.entity.Employee;
import com.loan.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, String>{

    @Query("select e from Employee e where e.account=?1")
    Employee findOneByAccount(String account);

    @Query("select new com.loan.model.EmployeeModel(e.id, e.name) from Employee e where e.department=?1")
    List<EmployeeModel> findAllIdName(String departmentId);

    @Modifying
    @Query("delete from Employee e where e.id=?1")
    int deleteById(String id);
}