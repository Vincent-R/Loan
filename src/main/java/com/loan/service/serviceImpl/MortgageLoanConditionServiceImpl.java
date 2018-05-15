package com.loan.service.serviceImpl;

import com.loan.dao.MortgageLoanConditionDao;
import com.loan.entity.MortgageLoanCondition;
import com.loan.service.MortgageLoanConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MortgageLoanConditionServiceImpl implements MortgageLoanConditionService{

    @Autowired
    private MortgageLoanConditionDao mortgageLoanConditionDao;

    @Override
    public MortgageLoanCondition findOneById(String id) {
        return mortgageLoanConditionDao.findOne(id);
    }

    @Override
    public List<MortgageLoanCondition> findAll() {
        return mortgageLoanConditionDao.findAll();
    }

    @Transactional
    @Override
    public MortgageLoanCondition save(MortgageLoanCondition mortgageLoanCondition) {
        return mortgageLoanConditionDao.save(mortgageLoanCondition);
    }
}
