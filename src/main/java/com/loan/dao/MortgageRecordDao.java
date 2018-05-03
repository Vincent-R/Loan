package com.loan.dao;

import com.loan.entity.MortgageRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageRecordDao extends JpaRepository<MortgageRecord, String>{
}
