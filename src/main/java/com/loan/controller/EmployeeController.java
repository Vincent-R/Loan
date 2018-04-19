package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.Employee;
import com.loan.service.EmployeeService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import com.loan.util.TokenSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<Employee> employeeLogin(@RequestParam(value = "userName", defaultValue = "") String userName,
                                              @RequestParam(value = "userPassword", defaultValue = "") String userPassword, HttpServletResponse httpServletResponse){
        Employee employee = employeeService.findOneByAccount(userName);
        DataReturn<Employee> result = null;
        if(employee == null){
            result = new DataReturn<>(Constant.RESULT_ERROR, "账户不存在" , null);
            return result;
        }
        if(!userPassword.equals(employee.getPassword())){
            result = new DataReturn<>(Constant.RESULT_ERROR, "密码错误" , null);
            return result;
        }
        httpServletResponse.setHeader("token", TokenSecurity.createToken(Constant.AUTHORIZE_TTLMILLIS, Constant.stringKey, employee.getId()));
        result = new DataReturn<>(Constant.RESULT_OK, "" , employee);
        return result;
    }

    @RequestMapping(value = "/getEmployee/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<Employee> getEmployee(@PathVariable("userId") String userId){
        Employee employee = employeeService.findOneById(userId);
        DataReturn<Employee> result = null;
        if(employee == null){
            result = new DataReturn<>(Constant.RESULT_ERROR, "账户不存在" , null);
            return result;
        }
        result = new DataReturn<>(Constant.RESULT_OK, "" , employee);
        return result;
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<String> updateEmployee(@RequestParam(value = "newEmployee", defaultValue = "") String newEmployee){
        Employee employee = JSON.parseObject(newEmployee, Employee.class);
        employee = employeeService.save(employee);
        if(null == employee){
            return new DataReturn<>(Constant.RESULT_ERROR, "更新用户失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "更新用户成功", employee.getId());
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<String> saveEmployee(@RequestParam(value = "newEmployee", defaultValue = "") String newEmployee){
        Employee employee = JSON.parseObject(newEmployee, Employee.class);
        employee.setId(UUID.randomUUID().toString().replace("-",""));
        employee = employeeService.save(employee);
        if(null == employee){
            return new DataReturn<>(Constant.RESULT_ERROR, "创建用户失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "创建新用户成功", employee.getId());
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<Integer> deleteEmployee(@RequestParam(value = "id", defaultValue = "") String id){
        int result = employeeService.deleteById(id);
        if(1 != result ){
            return new DataReturn<>(Constant.RESULT_ERROR, "删除用户失败", 0);
        }
        return new DataReturn<>(Constant.RESULT_OK, "删除用户成功", 1);
    }
}