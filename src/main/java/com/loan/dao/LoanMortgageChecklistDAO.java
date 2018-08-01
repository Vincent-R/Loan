package com.loan.dao;

import com.loan.entity.LoanMortgageChecklist;
import com.loan.entity.LoanMortgageChecklistExample;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

/**
 * LoanMortgageChecklistDAO继承基类
 */
@Repository
public interface LoanMortgageChecklistDAO extends MyBatisBaseDao<LoanMortgageChecklist, String, LoanMortgageChecklistExample> {
}