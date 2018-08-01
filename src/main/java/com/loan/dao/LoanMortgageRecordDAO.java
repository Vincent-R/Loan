package com.loan.dao;

import com.loan.entity.LoanMortgageRecord;
import com.loan.entity.LoanMortgageRecordExample;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

/**
 * LoanMortgageRecordDAO继承基类
 */
@Repository
public interface LoanMortgageRecordDAO extends MyBatisBaseDao<LoanMortgageRecord, String, LoanMortgageRecordExample> {
}