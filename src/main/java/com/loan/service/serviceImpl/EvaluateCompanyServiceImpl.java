package com.loan.service.serviceImpl;

import com.loan.dao.EvaluateCompanyDao;
import com.loan.entity.EvaluateCompany;
import com.loan.service.EvaluateCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvaluateCompanyServiceImpl implements EvaluateCompanyService{

    @Autowired
    private EvaluateCompanyDao evaluateCompanyDao;

    @Override
    public EvaluateCompany findOneById(String id) {
        return evaluateCompanyDao.findOne(id);
    }

    @Override
    public List<EvaluateCompany> findAll() {
        return evaluateCompanyDao.findAll();
    }

    @Transactional
    @Override
    public EvaluateCompany save(EvaluateCompany evaluateCompany) {
        return evaluateCompanyDao.save(evaluateCompany);
    }

    @Transactional
    @Override
    public void deleteOneById(String id) {
        evaluateCompanyDao.delete(id);
    }
}
