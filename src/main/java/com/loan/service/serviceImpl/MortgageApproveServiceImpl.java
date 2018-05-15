package com.loan.service.serviceImpl;

import com.loan.dao.MortgageApproveDao;
import com.loan.entity.MortgageApprove;
import com.loan.service.MortgageApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MortgageApproveServiceImpl implements MortgageApproveService {

    @Autowired
    private MortgageApproveDao mortgageApproveDao;

    @Override
    public MortgageApprove findOneById(String id) {
        return mortgageApproveDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageApprove save(MortgageApprove mortgageApprove) {
        return mortgageApproveDao.save(mortgageApprove);
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        mortgageApproveDao.delete(id);
    }
}
