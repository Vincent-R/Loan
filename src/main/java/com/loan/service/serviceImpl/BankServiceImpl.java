package com.loan.service.serviceImpl;

import com.loan.dao.BankDao;
import com.loan.entity.Bank;
import com.loan.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankDao bankDao;

    @Override
    public Bank findOneById(String id) {
        return bankDao.findOne(id);
    }

    @Override
    public List<Bank> findAll() {
        return bankDao.findAll();
    }

    @Transactional
    @Override
    public Bank save(Bank bank) {
        return bankDao.save(bank);
    }

    @Transactional
    @Override
    public void deleteOneById(String id) {
        bankDao.delete(id);
    }
}
