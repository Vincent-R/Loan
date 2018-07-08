package com.loan.controller;

import com.loan.entity.*;
import com.loan.service.LoanConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empty")
public class EmptyController {

    @Autowired
    private LoanConditionService loanConditionService;

    @ResponseBody
    @RequestMapping(value = "/announcement", method = RequestMethod.GET)
    public Announcement getEmptyAnnouncement(){
        return new Announcement();
    }

    @ResponseBody
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public Department getEmptyDepartment(){
        Department department = new Department();
        department.setId("");
        department.setName("");
        department.setDescription("");
        return department;
    }

    @ResponseBody
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Employee getEmptyEmployee(){
        Employee employee = new Employee();
        employee.setAccount("");
        employee.setDepartment_id("");
        employee.setId("");
        employee.setName("");
        employee.setPassword("");
        employee.setPhone("");
        return employee;
    }

    @ResponseBody
    @RequestMapping(value = "/m/record", method = RequestMethod.GET)
    public MortgageRecord getEmptyRecord(){
        MortgageRecord mortgageRecord = new MortgageRecord();
        mortgageRecord.setAdvice("");
        mortgageRecord.setAdvice_operator("");
        mortgageRecord.setCatalog("");
        mortgageRecord.setChecklist("");
        mortgageRecord.setChecklist_operator("");
        mortgageRecord.setForm("");
        mortgageRecord.setId("");
        mortgageRecord.setOrder_evaluate_company("");
        mortgageRecord.setProcess_id("");
        mortgageRecord.setVisa_address("");
        mortgageRecord.setVisa_operator("");
        return mortgageRecord;
    }

    @ResponseBody
    @RequestMapping(value = "/m/checklist", method = RequestMethod.GET)
    public MortgageCheckList getEmptyCheckList(){
        MortgageCheckList mortgageCheckList = new MortgageCheckList();
        mortgageCheckList.setAgent_name("");
        mortgageCheckList.setClient_id_number("");
        mortgageCheckList.setClient_id_type("");
        mortgageCheckList.setClient_name("");
        mortgageCheckList.setClient_phone("");
        mortgageCheckList.setClient_work_unit("");
        mortgageCheckList.setId("");
        mortgageCheckList.setLoan_amount("");
        mortgageCheckList.setLoan_period("");
        mortgageCheckList.setRemark("");
        List<MortgageHouse> mortgageHouseList = new ArrayList<>();
        MortgageHouse mortgageHouse = new MortgageHouse();
        mortgageHouse.setChecklist_id("");
        mortgageHouse.setEnquiry_result("");
        mortgageHouse.setTotal_price("");
        mortgageHouse.setId("");
        mortgageHouse.setArea("");
        mortgageHouseList.add(mortgageHouse);
        mortgageCheckList.setMortgageHouses(mortgageHouseList);
        return mortgageCheckList;
    }

    @ResponseBody
    @RequestMapping(value = "/m/house", method = RequestMethod.GET)
    public MortgageHouse getEmptyHouse(){
        MortgageHouse mortgageHouse = new MortgageHouse();
        mortgageHouse.setId("");
        mortgageHouse.setArea("");
        mortgageHouse.setTotal_price("");
        mortgageHouse.setEnquiry_result("");
        mortgageHouse.setChecklist_id("");
        return mortgageHouse;
    }

    @ResponseBody
    @RequestMapping(value = "/m/advice", method = RequestMethod.GET)
    public MortgageAdvice getEmptyAdvice(){
        MortgageAdvice mortgageAdvice = new MortgageAdvice();
        mortgageAdvice.setId("");
        return mortgageAdvice;
    }

    @ResponseBody
    @RequestMapping(value = "/m/catalog", method = RequestMethod.GET)
    public MortgageCatalog getEmptyCatalog(){
        MortgageCatalog mortgageCatalog = new MortgageCatalog();
        List<MortgageCatalogOther> mortgageCatalogOthers = new ArrayList<>();
        mortgageCatalogOthers.add(new MortgageCatalogOther());
        mortgageCatalog.setMortgageCatalogOthers(mortgageCatalogOthers);
        return mortgageCatalog;
    }

    @ResponseBody
    @RequestMapping(value = "/m/form", method = RequestMethod.GET)
    public MortgageForm getEmptyForm(){
        return new MortgageForm();
    }

    @ResponseBody
    @RequestMapping(value = "/m/report", method = RequestMethod.GET)
    public MortgageReport getEmptyReport(){
        return new MortgageReport();
    }

    @ResponseBody
    @RequestMapping(value = "/m/approve", method = RequestMethod.GET)
    public MortgageApprove getEmptyApprove(){
        return new MortgageApprove();
    }

    @ResponseBody
    @RequestMapping(value = "/m/conditions", method = RequestMethod.GET)
    public List<LoanCondition> getEmptyLoanConditions(){
        return loanConditionService.findAll();
    }
}
