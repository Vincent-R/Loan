package com.loan.dao;

import com.loan.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

//    @Query("select  d from Department d where d.id = ?1")
//    Department findById(int id);
//
    @Query("select d from Department d where d.name = ?1")
    Department findOneByName(String name);
//
//    @Query("select d from Department d")
//    List<Department> findAll();
//
    @Modifying
    @Query("delete from Department d where d.id = ?1")
    int deleteById(int id);
}