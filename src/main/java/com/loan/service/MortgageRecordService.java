package com.loan.service;

import com.loan.entity.MortgageRecord;

import java.util.List;

public interface MortgageRecordService {

    MortgageRecord findOneById(String id);

    MortgageRecord save(MortgageRecord mortgageRecord);
}
