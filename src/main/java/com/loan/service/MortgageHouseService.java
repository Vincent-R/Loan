package com.loan.service;

import com.loan.entity.MortgageHouse;

import java.util.List;

public interface MortgageHouseService {

    MortgageHouse findById(String id);

    MortgageHouse save(MortgageHouse mortgageHouse);

    List<MortgageHouse> findAll();
}
