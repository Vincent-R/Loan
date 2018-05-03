package com.loan.dao;

import com.loan.entity.MortgageAdvice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageAdviceDao extends JpaRepository<MortgageAdvice, String>{
}
