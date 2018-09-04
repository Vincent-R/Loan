package com.loan.controller.Manage;

import com.loan.entity.Bank;
import com.loan.service.BankService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(value = "银行模块接口",tags = "银行模块接口")
@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @ApiOperation(value = "获取所有银行信息")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<Bank>> getAllBank(){
        return new DataReturn<>(Constant.RESULT_OK, "" , bankService.findAll());
    }
}
