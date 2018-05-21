package com.loan.service.serviceImpl;

import com.loan.dao.LoanConditionDao;
import com.loan.entity.LoanCondition;
import com.loan.service.LoanConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoanConditionServiceImpl implements LoanConditionService {

    @Autowired
    private LoanConditionDao loanConditionDao;

    @Override
    public LoanCondition findOneById(String id) {
        return loanConditionDao.findOne(id);
    }

    @Override
    public List<LoanCondition> findAll() {
        return loanConditionDao.findAll();
    }

    @Transactional
    @Override
    public LoanCondition save(LoanCondition loanCondition) {
        return loanConditionDao.save(loanCondition);
    }
}
