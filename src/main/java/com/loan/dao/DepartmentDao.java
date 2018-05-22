package com.loan.dao;

import com.loan.entity.Department;
import com.loan.model.DepartmentModel;
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

//    @Query(value = "select new pers.zhuch.model.MyModel(u.userName, ui.name, ui.gender, ui.description) from UserInfo ui, User u where u.id = ui.userId")
    @Query("select new com.loan.model.DepartmentModel(d.id, d.name) from Department d")
    List<DepartmentModel> findAllIdName();
//
//    @Query("select d from Department d")
//    List<Department> findAll();
//
    @Modifying
    @Query("delete from Department d where d.id = ?1")
    int deleteById(int id);
}