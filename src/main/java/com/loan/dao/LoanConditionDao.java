package com.loan.dao;

import com.loan.entity.LoanCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanConditionDao extends JpaRepository<LoanCondition, String>{
}
