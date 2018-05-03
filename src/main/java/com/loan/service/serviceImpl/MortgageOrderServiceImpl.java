package com.loan.service.serviceImpl;

import com.loan.dao.MortgageOrderDao;
import com.loan.entity.MortgageOrder;
import com.loan.service.MortgageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MortgageOrderServiceImpl implements MortgageOrderService {

    @Autowired
    private MortgageOrderDao mortgageOrderDao;

    @Override
    public MortgageOrder findOneById(String id) {
        return mortgageOrderDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageOrder save(MortgageOrder mortgageOrder) {
        return mortgageOrderDao.save(mortgageOrder);
    }
}
