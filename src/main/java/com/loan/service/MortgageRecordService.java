package com.loan.service;

import com.loan.entity.MortgageRecord;

public interface MortgageRecordService {

    MortgageRecord findOneById(String id);

    MortgageRecord save(MortgageRecord mortgageRecord);
}
