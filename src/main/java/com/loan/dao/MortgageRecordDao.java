package com.loan.dao;

import com.loan.entity.MortgageRecord;
import com.loan.returnObj.MObjCommon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface MortgageRecordDao extends JpaRepository<MortgageRecord, String>{


}
