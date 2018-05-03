package com.loan.service;

import com.loan.entity.MortgageMortgage;

public interface MortgageMortgageService {

    MortgageMortgage findOneById(String id);;

    MortgageMortgage save(MortgageMortgage mortgageMortgage);
}
