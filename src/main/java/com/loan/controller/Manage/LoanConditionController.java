package com.loan.controller.Manage;

import com.loan.entity.LoanCondition;
import com.loan.service.LoanConditionService;
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
@Api(value = "贷款状态信息",tags = "贷款状态信息")
@RestController
@RequestMapping("/loanCondition")
public class LoanConditionController {

    @Autowired
    private LoanConditionService loanConditionService;

    @ApiOperation(value = "获取所有贷款状态信息")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<LoanCondition>> getAllLoanCondition(){
        return new DataReturn<>(Constant.RESULT_OK, "" , loanConditionService.findAll());
    }
}
