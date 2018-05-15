package com.loan.service.serviceImpl;

import com.loan.dao.MortgageCatalogDao;
import com.loan.entity.MortgageCatalog;
import com.loan.service.MortgageCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MortgageCatalogServiceImpl implements MortgageCatalogService{

    @Autowired
    private MortgageCatalogDao mortgageCatalogDao;

    @Override
    public MortgageCatalog findOneById(String id) {
        return mortgageCatalogDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageCatalog save(MortgageCatalog mortgageCatalog) {
        return mortgageCatalogDao.save(mortgageCatalog);
    }

    @Transactional
    @Override
    public void deleteOneById(String id) {
        mortgageCatalogDao.delete(id);
    }
}
