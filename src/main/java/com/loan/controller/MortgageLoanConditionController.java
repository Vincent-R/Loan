package com.loan.controller;

import com.loan.entity.MortgageLoanCondition;
import com.loan.service.MortgageLoanConditionService;
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
public class MortgageLoanConditionController {

    @Autowired
    private MortgageLoanConditionService mortgageLoanConditionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<MortgageLoanCondition>> getAllLoanCondition(){
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageLoanConditionService.findAll());
    }
}
