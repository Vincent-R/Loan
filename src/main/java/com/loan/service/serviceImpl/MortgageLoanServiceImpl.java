package com.loan.service.serviceImpl;

import com.loan.dao.MortgageLoanDao;
import com.loan.entity.MortgageLoan;
import com.loan.service.MortgageLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MortgageLoanServiceImpl implements MortgageLoanService {

    @Autowired
    private MortgageLoanDao mortgageLoanDao;

    @Override
    public MortgageLoan findOneById(String id) {
        return mortgageLoanDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageLoan save(MortgageLoan mortgageLoan) {
        return mortgageLoanDao.save(mortgageLoan);
    }
}
