package com.loan.dao;

import com.loan.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDao extends JpaRepository<Bank, String>{
}
