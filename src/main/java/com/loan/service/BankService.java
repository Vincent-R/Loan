package com.loan.service;

import com.loan.entity.Bank;

import java.util.List;

public interface BankService {

    Bank findOneById(String id);

    List<Bank> findAll();

    Bank save(Bank bank);

    void deleteOneById(String id);
}
