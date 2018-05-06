package com.loan.dao;

import com.loan.entity.MortgageReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageReportDao extends JpaRepository<MortgageReport, String>{
}
