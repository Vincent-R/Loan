package com.loan.dao;

import com.loan.entity.MortgageLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageLoanDao extends JpaRepository<MortgageLoan, String>{
}
