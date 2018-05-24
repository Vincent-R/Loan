package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.Employee;
import com.loan.model.EmployeeModel;
import com.loan.service.EmployeeService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import com.loan.util.TokenSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<Employee> getEmployee(@PathVariable("userId") String userId){
        if("".equals(userId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "用户ID不合法" , null);
        }
        Employee employee = employeeService.findOneById(userId);
        if(employee == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "账户不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , employee);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<String> updateEmployee(@RequestParam(value = "newEmployee", defaultValue = "") String newEmployee){
        if("".equals(newEmployee)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入用户不合法" , null);
        }
        Employee employee = JSON.parseObject(newEmployee, Employee.class);
        employee = employeeService.save(employee);
        if(null == employee){
            return new DataReturn<>(Constant.RESULT_ERROR, "更新用户失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "更新用户成功", employee.getId());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<String> saveEmployee(@RequestParam(value = "newEmployee", defaultValue = "") String newEmployee){
        if("".equals(newEmployee)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入用户不合法" , null);
        }
        Employee employee = JSON.parseObject(newEmployee, Employee.class);
        employee.setId(UUID.randomUUID().toString().replace("-",""));
        employee = employeeService.save(employee);
        if(null == employee){
            return new DataReturn<>(Constant.RESULT_ERROR, "创建用户失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "创建新用户成功", employee.getId());
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<Integer> deleteEmployee(@PathVariable("userId") String userId){
        if("".equals(userId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "用户ID不合法" , null);
        }
        int result = employeeService.deleteById(userId);
        if(1 != result ){
            return new DataReturn<>(Constant.RESULT_ERROR, "删除用户失败", 0);
        }
        return new DataReturn<>(Constant.RESULT_OK, "删除用户成功", 1);
    }

    @RequestMapping(value = "/allModel/{departmentId}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<EmployeeModel>> getAllEmployeeModel(@PathVariable("departmentId") String departmentId){
        return new DataReturn<>(Constant.RESULT_OK, "", employeeService.findAllIdName(departmentId));
    }
}