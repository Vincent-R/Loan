package com.loan.controller;

import com.loan.entity.Bank;
import com.loan.entity.Employee;
import com.loan.entity.MortgageLoanCondition;
import com.loan.service.BankService;
import com.loan.service.EmployeeService;
import com.loan.service.MortgageLoanConditionService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import com.loan.util.TokenSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/")
public class LoanController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BankService bankService;

    @Autowired
    private MortgageLoanConditionService mortgageLoanConditionService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<Employee> employeeLogin(@RequestParam(value = "name", defaultValue = "") String name,
                                              @RequestParam(value = "password", defaultValue = "") String password, HttpServletResponse httpServletResponse){
        if("".equals(name)){
            return new DataReturn<>(Constant.RESULT_ERROR, "请输入正确的用户名称" , null);
        }
        Employee employee = employeeService.findOneByAccount(name);
        if(employee == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "账户不存在" , null);
        }
        if(!password.equals(employee.getPassword())){
            return new DataReturn<>(Constant.RESULT_ERROR, "密码错误" , null);
        }
        httpServletResponse.setHeader("token", TokenSecurity.createToken(Constant.AUTHORIZE_NOTIME, Constant.stringKey, employee.getId()));
        return new DataReturn<>(Constant.RESULT_OK, "" , employee);
    }

    @RequestMapping(value = "banks", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<Bank>> getAllBank(){
        return new DataReturn<>(Constant.RESULT_OK, "" , bankService.findAll());
    }

    @RequestMapping(value = "loanConditions", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<MortgageLoanCondition>> getAllLoanCondition(){
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageLoanConditionService.findAll());
    }
}
