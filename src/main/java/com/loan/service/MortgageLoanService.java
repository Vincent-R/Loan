package com.loan.service;

import com.loan.entity.MortgageLoan;

public interface MortgageLoanService {

    MortgageLoan findOneById(String id);;

    MortgageLoan save(MortgageLoan mortgageLoan);
}
