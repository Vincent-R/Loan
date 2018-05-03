package com.loan.service.serviceImpl;

import com.loan.dao.MortgageMortgageDao;
import com.loan.entity.MortgageMortgage;
import com.loan.service.MortgageMortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MortgageMortgageServiceImpl implements MortgageMortgageService{

    @Autowired
    private MortgageMortgageDao mortgageMortgageDao;

    @Override
    public MortgageMortgage findOneById(String id) {
        return mortgageMortgageDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageMortgage save(MortgageMortgage mortgageMortgage) {
        return mortgageMortgageDao.save(mortgageMortgage);
    }
}
