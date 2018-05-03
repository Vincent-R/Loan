package com.loan.service.serviceImpl;

import com.loan.dao.MortgageCheckListDao;
import com.loan.entity.MortgageCheckList;
import com.loan.service.MortgageCheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MortgageCheckListServiceImpl implements MortgageCheckListService {

    @Autowired
    private MortgageCheckListDao mortgageCheckListDao;

    @Transactional
    @Override
    public MortgageCheckList save(MortgageCheckList mortgageCheckList) {
        return mortgageCheckListDao.save(mortgageCheckList);
    }

    @Override
    public MortgageCheckList findOneById(String id) {
        return mortgageCheckListDao.findOne(id);
    }

    @Override
    public List<MortgageCheckList> findAll() {
        return mortgageCheckListDao.findAll();
    }
}
