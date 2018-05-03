package com.loan.dao;

import com.loan.entity.MortgageForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageFormDao extends JpaRepository<MortgageForm, String>{
}
