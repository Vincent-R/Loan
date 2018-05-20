package com.loan.service;

import com.loan.entity.EvaluateCompany;

import java.util.List;

public interface EvaluateCompanyService {

    EvaluateCompany findOneById(String id);

    List<EvaluateCompany> findAll();

    EvaluateCompany save(EvaluateCompany evaluateCompany);

    void deleteOneById(String id);
}
