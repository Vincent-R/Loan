package com.loan.controller.Other;

import com.loan.entity.*;
import com.loan.service.LoanConditionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "原Empty查询数据结构", tags = "原Empty查询数据结构")
@RestController
@RequestMapping("/empty")
public class EmptyController {

    @Autowired
    private LoanConditionService loanConditionService;

    @ApiOperation(value = "获取announcement数据结构")
    @RequestMapping(value = "/announcement", method = RequestMethod.GET)
    @ResponseBody
    public Announcement getEmptyAnnouncement(){
        return new Announcement();
    }

    @ApiOperation(value = "获取department数据结构")
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    @ResponseBody
    public Department getEmptyDepartment(){
        Department department = new Department();
        department.setId("");
        department.setName("");
        department.setDescription("");
        return department;
    }

    @ApiOperation(value = "获取employee数据结构")
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @ResponseBody
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

    @ApiOperation(value = "获取record数据结构")
    @RequestMapping(value = "/m/record", method = RequestMethod.GET)
    @ResponseBody
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

    @ApiOperation(value = "获取checklist数据结构")
    @RequestMapping(value = "/m/checklist", method = RequestMethod.GET)
    @ResponseBody
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

    @ApiOperation(value = "获取house数据结构")
    @RequestMapping(value = "/m/house", method = RequestMethod.GET)
    @ResponseBody
    public MortgageHouse getEmptyHouse(){
        MortgageHouse mortgageHouse = new MortgageHouse();
        mortgageHouse.setId("");
        mortgageHouse.setArea("");
        mortgageHouse.setTotal_price("");
        mortgageHouse.setEnquiry_result("");
        mortgageHouse.setChecklist_id("");
        return mortgageHouse;
    }

    @ApiOperation(value = "获取advice数据结构")
    @RequestMapping(value = "/m/advice", method = RequestMethod.GET)
    @ResponseBody
    public MortgageAdvice getEmptyAdvice(){
        MortgageAdvice mortgageAdvice = new MortgageAdvice();
        mortgageAdvice.setId("");
        return mortgageAdvice;
    }

    @ApiOperation(value = "获取catalog数据结构")
    @RequestMapping(value = "/m/catalog", method = RequestMethod.GET)
    @ResponseBody
    public MortgageCatalog getEmptyCatalog(){
        MortgageCatalog mortgageCatalog = new MortgageCatalog();
        List<MortgageCatalogOther> mortgageCatalogOthers = new ArrayList<>();
        mortgageCatalogOthers.add(new MortgageCatalogOther());
        mortgageCatalog.setMortgageCatalogOthers(mortgageCatalogOthers);
        return mortgageCatalog;
    }

    @ApiOperation(value = "获取form数据结构")
    @RequestMapping(value = "/m/form", method = RequestMethod.GET)
    @ResponseBody
    public MortgageForm getEmptyForm(){
        return new MortgageForm();
    }

    @ApiOperation(value = "获取report数据结构")
    @RequestMapping(value = "/m/report", method = RequestMethod.GET)
    @ResponseBody
    public MortgageReport getEmptyReport(){
        return new MortgageReport();
    }

    @ApiOperation(value = "获取approve数据结构")
    @RequestMapping(value = "/m/approve", method = RequestMethod.GET)
    @ResponseBody
    public MortgageApprove getEmptyApprove(){
        return new MortgageApprove();
    }

    @ApiOperation(value = "获取conditions数据结构")
    @RequestMapping(value = "/m/conditions", method = RequestMethod.GET)
    @ResponseBody
    public List<LoanCondition> getEmptyLoanConditions(){
        return loanConditionService.findAll();
    }
}
