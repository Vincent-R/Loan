package com.loan.service.serviceImpl;

import com.loan.dao.MortgageRecordDao;
import com.loan.dao.MortgageReportDao;
import com.loan.entity.MortgageRecord;
import com.loan.entity.MortgageReport;
import com.loan.service.MortgageRecordService;
import com.loan.service.MortgageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MortgageReportServiceImpl implements MortgageReportService{

    @Autowired
    private MortgageReportDao mortgageReportDao;

    @Override
    public MortgageReport findOneById(String id) {
        return mortgageReportDao.findOne(id);
    }

    @Transactional
    @Override
    public MortgageReport save(MortgageReport mortgageReport) {
        return mortgageReportDao.save(mortgageReport);
    }
}
