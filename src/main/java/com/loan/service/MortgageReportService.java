package com.loan.service;

import com.loan.entity.MortgageReport;

public interface MortgageReportService {

    MortgageReport findOneById(String id);

    MortgageReport save(MortgageReport mortgageReport);
}
