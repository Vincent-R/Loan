package com.loan.dao;

import com.loan.entity.MortgageCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageCatalogDao extends JpaRepository<MortgageCatalog, String>{
}
