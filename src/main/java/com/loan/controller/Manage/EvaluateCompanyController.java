package com.loan.controller.Manage;

import com.loan.entity.EvaluateCompany;
import com.loan.service.EvaluateCompanyService;
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
@Api(value = "评估公司信息",tags ="评估公司信息")
@RestController
@RequestMapping("/evaluateCompany")
public class EvaluateCompanyController {

    @Autowired
    private EvaluateCompanyService evaluateCompanyService;

    @ApiOperation(value = "获取所有评估公司信息")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<EvaluateCompany>> getAllEvaluateCompany(){
        return new DataReturn<>(Constant.RESULT_OK, "" , evaluateCompanyService.findAll());
    }
}
