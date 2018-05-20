package com.loan.controller;

import com.loan.entity.EvaluateCompany;
import com.loan.service.EvaluateCompanyService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evaluateCompany")
public class EvaluateCompanyController {

    @Autowired
    private EvaluateCompanyService evaluateCompanyService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<EvaluateCompany>> getAllEvaluateCompany(){
        return new DataReturn<>(Constant.RESULT_OK, "" , evaluateCompanyService.findAll());
    }
}
