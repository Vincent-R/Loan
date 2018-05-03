package com.loan.service;

import com.loan.entity.MortgageForm;

public interface MortgageFormService {

    MortgageForm findOneById(String id);

    MortgageForm save(MortgageForm mortgageForm);
}
