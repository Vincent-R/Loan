package com.loan.service.serviceImpl;

import com.loan.dao.MortgageAdviceDao;
import com.loan.entity.MortgageAdvice;
import com.loan.service.MortgageAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MortgageAdviceServiceImpl implements MortgageAdviceService{

    @Autowired
    private MortgageAdviceDao mortgageAdviceDao;

    @Override
    public MortgageAdvice findOneById(String id) {
        return mortgageAdviceDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageAdvice save(MortgageAdvice mortgageAdvice) {
        return mortgageAdviceDao.save(mortgageAdvice);
    }
}
