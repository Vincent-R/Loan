package com.loan.dao;

import com.loan.entity.HouseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRecordDao extends JpaRepository<HouseRecord, String>{
}
