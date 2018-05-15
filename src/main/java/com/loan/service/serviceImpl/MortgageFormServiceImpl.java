package com.loan.service.serviceImpl;

import com.loan.dao.MortgageFormDao;
import com.loan.entity.MortgageForm;
import com.loan.service.MortgageFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MortgageFormServiceImpl implements MortgageFormService {

    @Autowired
    private MortgageFormDao mortgageFormDao;

    @Override
    public MortgageForm findOneById(String id) {
        return mortgageFormDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageForm save(MortgageForm mortgageForm) {
        return mortgageFormDao.save(mortgageForm);
    }

    @Override
    public void deleteOneById(String id) {
        mortgageFormDao.delete(id);
    }
}
