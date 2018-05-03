package com.loan.dao;

import com.loan.entity.MortgageOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageOrderDao extends JpaRepository<MortgageOrder, String>{
}
