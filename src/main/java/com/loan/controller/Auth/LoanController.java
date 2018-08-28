package com.loan.controller.Auth;

import com.loan.entity.Employee;
import com.loan.service.EmployeeService;
import com.loan.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Api(value = "用户登录接口",tags ="用户登录接口")
@RestController
@RequestMapping("/auth")
public class LoanController {

    private Logger logger = Logger.getLogger(LoanController.class);

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public JSONResult<Result> orderRuntimeExceptionHandler(RuntimeException ex){

        logger.error("  ",ex);
        JSONResult<Result> resp =new JSONResult<Result>();
        Result data =new Result ();
        resp.setData(data);
        resp.setMessage(ex.getMessage());
        resp.setSuccess(false);
        return resp;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public JSONResult<Result> orderExceptionHandler(Exception ex){

        logger.error("  ",ex);
        JSONResult<Result> resp =new JSONResult<Result>();
        Result data =new Result ();
        resp.setData(data);
        resp.setMessage("未知异常");
        resp.setSuccess(false);
        return resp;
    }

    @Transactional(rollbackFor = Exception.class)

    @ApiOperation(value = "用户登录" ,  notes="用户登录", httpMethod = "GET")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "name",value = "用户ID", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "password",value = "用户密码", dataType = "String", paramType = "query", required = true)})
    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult<LoginResult> employeeLogin(@RequestParam(value = "name", defaultValue = "") String name,
                                              @RequestParam(value = "password", defaultValue = "") String password, HttpServletResponse httpServletResponse) throws NotFoundException, UnsupportedEncodingException {
        JSONResult<LoginResult> resp = new JSONResult<LoginResult>();
        LoginResult resultData = new LoginResult();
        resp.setData(resultData);
        resp.setStatusCode(200);
        resp.setMessage("用户登录成功！");
        resp.setSuccess(true);
        if("".equals(name)){
            throw new NotFoundException("请输入正确的用户名称");
        }
        Employee employee = employeeService.findOneByAccount(name);
        if(employee == null){
            throw new NotFoundException("账户不存在");
        }
        if(!password.equals(employee.getPassword())){
            throw new NotFoundException("密码错误");
        }
        //把token放到Header里面
        String token = TokenSecurity.createToken(Constant.AUTHORIZE_NOTIME, Constant.stringKey, employee.getId());
        httpServletResponse.setHeader("token", token);
        Cookie cookie = new Cookie("token",token);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);


        LoginResult loginResult = new LoginResult();
        loginResult.setId(employee.getId());
        loginResult.setToken(token);
        loginResult.setAccount(employee.getAccount());
        loginResult.setDepartment_id(employee.getDepartment_id());
        loginResult.setRole(employee.getRole());




        resp.setData(loginResult);
        return resp;
    }
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "根据用户ID获取用户的信息和用户的响应权限" ,  notes="根据用户ID获取用户的信息和用户的响应权限")
    @ApiImplicitParam(value = "用户ID", required = true)
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<Employee> getEmployeeById(@PathVariable String id) throws NotFoundException{
        Employee employee = null;
        try{
            employee = employeeService.findOneById(id);
        }catch (Exception e){
            e.toString();
            throw new NotFoundException("该用户不存在！");
        }
        if(null != employee){
            return new DataReturn<>(Constant.RESULT_OK, "" , employee);
        }else {
            throw new NotFoundException("该用户不存在！");
        }

    }
}
