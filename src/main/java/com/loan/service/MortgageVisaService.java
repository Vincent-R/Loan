package com.loan.service;

import com.loan.entity.MortgageVisa;

public interface MortgageVisaService {

    MortgageVisa findOneById(String id);;

    MortgageVisa save(MortgageVisa mortgageVisa);
}
