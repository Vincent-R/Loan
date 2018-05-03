package com.loan.service.serviceImpl;

import com.loan.dao.MortgageHouseDao;
import com.loan.entity.MortgageHouse;
import com.loan.service.MortgageHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MortgageHouseServiceImpl implements MortgageHouseService {

    @Autowired
    private MortgageHouseDao mortgageHouseDao;

    @Transactional
    @Override
    public MortgageHouse save(MortgageHouse mortgageHouse) {
        return mortgageHouseDao.save(mortgageHouse);
    }

    @Override
    public MortgageHouse findOneById(String id) {
        return mortgageHouseDao.findOne(id);
    }

    @Override
    public List<MortgageHouse> findAll() {
        return mortgageHouseDao.findAll();
    }
}
