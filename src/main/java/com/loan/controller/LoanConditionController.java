package com.loan.controller;

import com.loan.entity.LoanCondition;
import com.loan.service.LoanConditionService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loanCondition")
public class LoanConditionController {

    @Autowired
    private LoanConditionService loanConditionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<LoanCondition>> getAllLoanCondition(){
        return new DataReturn<>(Constant.RESULT_OK, "" , loanConditionService.findAll());
    }
}
