package com.loan.dao;

import com.loan.entity.HouseCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseCatalogDao extends JpaRepository<HouseCatalog, String>{
}
