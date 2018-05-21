package com.loan.dao;

import com.loan.entity.MortgageReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MortgageReportDao extends JpaRepository<MortgageReport, String>{
    @Modifying
    @Query("delete from MortgageReport mr where mr.loan_id=?1")
    int deleteAllByLoanId(String loanId);
}
