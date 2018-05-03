package com.loan.service;

import com.loan.entity.MortgageAdvice;

public interface MortgageAdviceService {

    MortgageAdvice findOneById(String id);

    MortgageAdvice save(MortgageAdvice mortgageAdvice);
}
