package com.loan.service.serviceImpl;

import com.loan.dao.MortgageCatalogOtherDao;
import com.loan.entity.MortgageCatalogOther;
import com.loan.service.MortgageCatalogOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MortgageCatalogOtherServiceImpl implements MortgageCatalogOtherService {

    @Autowired
    private MortgageCatalogOtherDao mortgageCatalogOtherDao;

    @Override
    public MortgageCatalogOther findOneById(String id) {
        return mortgageCatalogOtherDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageCatalogOther save(MortgageCatalogOther mortgageCatalogOther) {
        return mortgageCatalogOtherDao.save(mortgageCatalogOther);
    }
}
