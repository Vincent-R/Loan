package com.loan.dao;

import com.loan.entity.MortgageApprove;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageApproveDao extends JpaRepository<MortgageApprove, String>{
}
