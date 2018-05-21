package com.loan.service;

import com.loan.entity.MortgageReport;

import java.util.List;

public interface MortgageReportService {

    MortgageReport findOneById(String id);

    MortgageReport save(MortgageReport mortgageReport);

    List<MortgageReport> saveAll(List<MortgageReport> mortgageReports);

    int deleteAllByLoanId(String loanId);

    void deleteOneById(String id);
}
