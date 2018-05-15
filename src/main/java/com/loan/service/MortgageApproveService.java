package com.loan.service;

import com.loan.entity.MortgageApprove;

public interface MortgageApproveService {

    MortgageApprove findOneById(String id);

    MortgageApprove save(MortgageApprove mortgageApprove);

    void deleteById(String id);
}
