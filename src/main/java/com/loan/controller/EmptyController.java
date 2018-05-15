package com.loan.controller;

import com.loan.entity.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empty")
public class EmptyController {

    @ResponseBody
    @RequestMapping(value = "/announcement", method = RequestMethod.GET)
    public Announcement getEmptyAnnouncement(){
        return new Announcement();
    }

    @ResponseBody
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public Department getEmptyDepartment(){
        return new Department();
    }

    @ResponseBody
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Employee getEmptyEmployee(){
        return new Employee();
    }

    @ResponseBody
    @RequestMapping(value = "/m/record", method = RequestMethod.GET)
    public MortgageRecord getEmptyRecord(){
        return new MortgageRecord();
    }

    @ResponseBody
    @RequestMapping(value = "/m/checklist", method = RequestMethod.GET)
    public MortgageCheckList getEmptyCheckList(){
        MortgageCheckList mortgageCheckList = new MortgageCheckList();
        List<MortgageHouse> mortgageHouseList = new ArrayList<>();
        mortgageHouseList.add(new MortgageHouse());
        mortgageCheckList.setMortgageHouses(mortgageHouseList);
        return mortgageCheckList;
    }

    @ResponseBody
    @RequestMapping(value = "/m/house", method = RequestMethod.GET)
    public MortgageHouse getEmptyHouse(){
        return new MortgageHouse();
    }

    @ResponseBody
    @RequestMapping(value = "/m/advice", method = RequestMethod.GET)
    public MortgageAdvice getEmptyAdvice(){
        return new MortgageAdvice();
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
}