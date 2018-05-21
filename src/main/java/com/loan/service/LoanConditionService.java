package com.loan.service;

import com.loan.entity.LoanCondition;

import java.util.List;

public interface LoanConditionService {

    LoanCondition findOneById(String id);

    List<LoanCondition> findAll();

    LoanCondition save(LoanCondition loanCondition);
}
