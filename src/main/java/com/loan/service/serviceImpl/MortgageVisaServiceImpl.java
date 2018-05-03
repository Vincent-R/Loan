package com.loan.service.serviceImpl;

import com.loan.dao.MortgageVisaDao;
import com.loan.entity.MortgageVisa;
import com.loan.service.MortgageVisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MortgageVisaServiceImpl implements MortgageVisaService{

    @Autowired
    private MortgageVisaDao mortgageVisaDao;

    @Override
    public MortgageVisa findOneById(String id) {
        return mortgageVisaDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageVisa save(MortgageVisa mortgageVisa) {
        return mortgageVisaDao.save(mortgageVisa);
    }
}
