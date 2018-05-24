package com.loan.service.serviceImpl;

import com.loan.dao.EmployeeDao;
import com.loan.entity.Employee;
import com.loan.model.EmployeeModel;
import com.loan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee findOneById(String id) {
        return employeeDao.findOne(id);
    }

    @Override
    public Employee findOneByAccount(String account) {
        return employeeDao.findOneByAccount(account);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public List<EmployeeModel> findAllIdName(String departmentId) {
        return employeeDao.findAllIdName(departmentId);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Transactional
    @Override
    public int deleteById(String id) {
        return employeeDao.deleteById(id);
    }
}