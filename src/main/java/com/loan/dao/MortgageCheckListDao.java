package com.loan.dao;

import com.loan.entity.MortgageCheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MortgageCheckListDao extends JpaRepository<MortgageCheckList, String>{

    @Modifying
    @Query("delete from MortgageCheckList mc where mc.id=?1")
    int deleteById(String id);
}
