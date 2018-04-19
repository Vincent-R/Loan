package com.loan.dao;

import com.loan.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDao extends JpaRepository<Employee, String>{

    @Query("select e from Employee e where e.account=?1")
    Employee findOneByAccount(String account);

    @Modifying
    @Query("delete from Employee e where e.id=:id")
    int deleteById(String id);
}