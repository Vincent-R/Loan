package com.loan.service.serviceImpl;

import com.loan.dao.MortgageRecordDao;
import com.loan.entity.MortgageRecord;
import com.loan.service.MortgageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MortgageRecordServiceImpl implements MortgageRecordService{

    @Autowired
    private MortgageRecordDao mortgageRecordDao;

    @Override
    public MortgageRecord findOneById(String id) {
        return mortgageRecordDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageRecord save(MortgageRecord mortgageRecord) {
        return mortgageRecordDao.save(mortgageRecord);
    }
}
