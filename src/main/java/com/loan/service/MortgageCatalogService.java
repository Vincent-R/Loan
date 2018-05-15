package com.loan.service;

import com.loan.entity.MortgageCatalog;

public interface MortgageCatalogService {

    MortgageCatalog findOneById(String id);

    MortgageCatalog save(MortgageCatalog mortgageCatalog);

    void deleteOneById(String id);
}
