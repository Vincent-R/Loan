package com.loan.service;

import com.loan.entity.MortgageLoanCondition;

import java.util.List;

public interface MortgageLoanConditionService {

    MortgageLoanCondition findOneById(String id);

    List<MortgageLoanCondition> findAll();

    MortgageLoanCondition save(MortgageLoanCondition mortgageLoanCondition);
}
