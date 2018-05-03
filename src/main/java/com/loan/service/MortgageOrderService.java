package com.loan.service;

import com.loan.entity.MortgageOrder;

public interface MortgageOrderService{

    MortgageOrder findOneById(String id);

    MortgageOrder save(MortgageOrder mortgageOrder);
}
