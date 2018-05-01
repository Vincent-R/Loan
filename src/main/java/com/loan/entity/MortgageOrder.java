package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_mortgage_order", schema = "loan")
public class MortgageOrder {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "agent")
    private String agent;

    @Basic
    @Column(name = "load_type")
    private String load_type;

    @Basic
    @Column(name = "bank")
    private String bank;

    @Basic
    @Column(name = "manager")
    private String manager;

    @Basic
    @Column(name = "manager_phone")
    private String manager_phone;

    @Basic
    @Column(name = "property_owner")
    private String property_owner;

    @Basic
    @Column(name = "property_owner_phone")
    private String property_owner_phone;

    @Basic
    @Column(name = "property_owner_address")
    private String property_owner_address;

    @Basic
    @Column(name = "require_price")
    private String require_price;

    @Basic
    @Column(name = "loan_type")
    private String loan_type;

    @Basic
    @Column(name = "receiver")
    private String receiver;

    @Basic
    @Column(name = "receiver_phone")
    private String receiver_phone;

    @Basic
    @Column(name = "receiver_address")
    private String receiver_address;

    @Basic
    @Column(name = "salesman")
    private String salesman;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "order_time")
    private Date order_time;

    @Basic
    @Column(name = "evaluation_company")
    private String evaluation_company;

    @Basic
    @Column(name = "order_state")
    private int order_state;

    @Basic
    @Column(name = "report_time")
    private Date report_time;

    @Basic
    @Column(name = "report_state")
    private int report_state;

    @Basic
    @Column(name = "report_type")
    private int report_type;

    @Basic
    @Column(name = "report_obligee")
    private String report_obligee;

    @Basic
    @Column(name = "report_borrower")
    private String report_borrower;

    @Basic
    @Column(name = "report_repose")
    private String report_repose;

    @Basic
    @Column(name = "report_house_age")
    private String report_house_age;

    @Basic
    @Column(name = "report_house_area")
    private String report_house_area;

    @Basic
    @Column(name = "report_house_single")
    private String report_house_single;

    @Basic
    @Column(name = "report_house_total")
    private String report_house_total;

    @Basic
    @Column(name = "report_loan_amount")
    private String report_loan_amount;

    @Basic
    @Column(name = "report_loan_year")
    private String report_loan_year;

    @Basic
    @Column(name = "report_first")
    private boolean report_first;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getLoad_type() {
        return load_type;
    }

    public void setLoad_type(String load_type) {
        this.load_type = load_type;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManager_phone() {
        return manager_phone;
    }

    public void setManager_phone(String manager_phone) {
        this.manager_phone = manager_phone;
    }

    public String getProperty_owner() {
        return property_owner;
    }

    public void setProperty_owner(String property_owner) {
        this.property_owner = property_owner;
    }

    public String getProperty_owner_phone() {
        return property_owner_phone;
    }

    public void setProperty_owner_phone(String property_owner_phone) {
        this.property_owner_phone = property_owner_phone;
    }

    public String getProperty_owner_address() {
        return property_owner_address;
    }

    public void setProperty_owner_address(String property_owner_address) {
        this.property_owner_address = property_owner_address;
    }

    public String getRequire_price() {
        return require_price;
    }

    public void setRequire_price(String require_price) {
        this.require_price = require_price;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getEvaluation_company() {
        return evaluation_company;
    }

    public void setEvaluation_company(String evaluation_company) {
        this.evaluation_company = evaluation_company;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public Date getReport_time() {
        return report_time;
    }

    public void setReport_time(Date report_time) {
        this.report_time = report_time;
    }

    public int getReport_state() {
        return report_state;
    }

    public void setReport_state(int report_state) {
        this.report_state = report_state;
    }

    public int getReport_type() {
        return report_type;
    }

    public void setReport_type(int report_type) {
        this.report_type = report_type;
    }

    public String getReport_obligee() {
        return report_obligee;
    }

    public void setReport_obligee(String report_obligee) {
        this.report_obligee = report_obligee;
    }

    public String getReport_borrower() {
        return report_borrower;
    }

    public void setReport_borrower(String report_borrower) {
        this.report_borrower = report_borrower;
    }

    public String getReport_repose() {
        return report_repose;
    }

    public void setReport_repose(String report_repose) {
        this.report_repose = report_repose;
    }

    public String getReport_house_age() {
        return report_house_age;
    }

    public void setReport_house_age(String report_house_age) {
        this.report_house_age = report_house_age;
    }

    public String getReport_house_area() {
        return report_house_area;
    }

    public void setReport_house_area(String report_house_area) {
        this.report_house_area = report_house_area;
    }

    public String getReport_house_single() {
        return report_house_single;
    }

    public void setReport_house_single(String report_house_single) {
        this.report_house_single = report_house_single;
    }

    public String getReport_house_total() {
        return report_house_total;
    }

    public void setReport_house_total(String report_house_total) {
        this.report_house_total = report_house_total;
    }

    public String getReport_loan_amount() {
        return report_loan_amount;
    }

    public void setReport_loan_amount(String report_loan_amount) {
        this.report_loan_amount = report_loan_amount;
    }

    public String getReport_loan_year() {
        return report_loan_year;
    }

    public void setReport_loan_year(String report_loan_year) {
        this.report_loan_year = report_loan_year;
    }

    public boolean isReport_first() {
        return report_first;
    }

    public void setReport_first(boolean report_first) {
        this.report_first = report_first;
    }
}
