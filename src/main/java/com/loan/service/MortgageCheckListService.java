package com.loan.service;

import com.loan.entity.MortgageCheckList;

import java.util.List;

public interface MortgageCheckListService {

    MortgageCheckList findById(String id);

    MortgageCheckList save(MortgageCheckList mortgageCheckList);

    List<MortgageCheckList> findAll();
}
