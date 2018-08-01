package com.loan.dao;

import com.loan.entity.LoanMortgageRecord;
import com.loan.entity.LoanMortgageRecordExample;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.loan.returnObj.MObjCommon;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * LoanMortgageRecordDAO继承基类
 */
@Repository
public interface LoanMortgageRecordDAO extends MyBatisBaseDao<LoanMortgageRecord, String, LoanMortgageRecordExample> {


    List<MObjCommon> queryRecordChecklist(@Param("idList") List<String> idList);


}