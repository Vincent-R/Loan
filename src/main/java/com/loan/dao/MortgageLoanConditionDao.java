package com.loan.dao;

import com.loan.entity.MortgageLoanCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageLoanConditionDao extends JpaRepository<MortgageLoanCondition, String>{
}
