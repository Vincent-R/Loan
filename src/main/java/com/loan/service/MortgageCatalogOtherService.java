package com.loan.service;

import com.loan.entity.MortgageCatalogOther;

public interface MortgageCatalogOtherService {

    MortgageCatalogOther findOneById(String id);

    MortgageCatalogOther save(MortgageCatalogOther mortgageCatalogOther);
}
