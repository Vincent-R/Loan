package com.loan.dao;

import com.loan.entity.MortgageCheckList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageCheckListDao extends JpaRepository<MortgageCheckList, String>{
}
