package com.loan.service.serviceImpl;

import com.loan.dao.DepartmentDao;
import com.loan.entity.Department;
import com.loan.model.DepartmentModel;
import com.loan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Department findOneById(String id) {
        return departmentDao.findOneById(id);
    }

    @Override
    public Department findOneByName(String name) {
        return departmentDao.findOneByName(name);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public List<DepartmentModel> findAllIdName() {
        return departmentDao.findAllIdName();
    }

    @Transactional
    @Override
    public Department save(Department department) {
        return departmentDao.save(department);
    }

    @Transactional
    @Override
    public int deleteById(String id) {
        return departmentDao.deleteById(id);
    }
}