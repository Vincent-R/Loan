package com.loan.dao;

import com.loan.entity.LoanTableValue;
import com.loan.entity.LoanTableValueExample;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.NotEmpty;

public interface LoanTableValueDao {
    long countByExample(LoanTableValueExample example);

    int deleteByExample(LoanTableValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanTableValue record);

    int insertSelective(LoanTableValue record);

    List<LoanTableValue> selectByExample(LoanTableValueExample example);

    LoanTableValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanTableValue record, @Param("example") LoanTableValueExample example);

    int updateByExample(@Param("record") LoanTableValue record, @Param("example") LoanTableValueExample example);

    int updateByPrimaryKeySelective(LoanTableValue record);

    int updateByPrimaryKey(LoanTableValue record);
}