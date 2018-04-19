package com.loan.dao;

import com.loan.entity.MortgageHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageHouseDao extends JpaRepository<MortgageHouse, String>{
}
