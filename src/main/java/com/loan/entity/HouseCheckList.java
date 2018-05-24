package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_house_checklist", schema = "loan")
public class HouseCheckList {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "finish_time")
    private Date finish_time;

    @Basic
    @Column(name = "borrower_name")
    private String borrower_name;

    @Basic
    @Column(name = "borrower_phone")
    private String borrower_phone;

    @Basic
    @Column(name = "borrower_company")
    private String borrower_company;

    @Basic
    @Column(name = "borrower_company_phone")
    private String borrower_company_phone;

    @Basic
    @Column(name = "borrower_salary")
    private String borrower_salary;

    @Basic
    @Column(name = "borrower_address")
    private String borrower_address;

    @Basic
    @Column(name = "borrower_resident_city")
    private String borrower_resident_city;

    @Basic
    @Column(name = "borrower_certificate_type")
    private String borrower_certificate_type;

    @Basic
    @Column(name = "borrower_certificate_number")
    private String borrower_certificate_number;

    @Basic
    @Column(name = "borrower_spouse_name")
    private String borrower_spouse_name;

    @Basic
    @Column(name = "borrower_spouse_phone")
    private String borrower_spouse_phone;

    @Basic
    @Column(name = "borrower_spouse_company")
    private String borrower_spouse_company;

    @Basic
    @Column(name = "borrower_spouse_company_phone")
    private String borrower_spouse_company_phone;

    @Basic
    @Column(name = "borrower_spouse_resident_city")
    private String borrower_spouse_resident_city;

    @Basic
    @Column(name = "borrower_spouse_certificate_type")
    private String borrower_spouse_certificate_type;

    @Basic
    @Column(name = "borrower_spouse_certificate_number")
    private String borrower_spouse_certificate_number;

    @Basic
    @Column(name = "owner_name")
    private String owner_name;

    @Basic
    @Column(name = "owner_phone")
    private String owner_phone;

    @Basic
    @Column(name = "owner_spouse_name")
    private String owner_spouse_name;

    @Basic
    @Column(name = "owner_spouse_phone")
    private String owner_spouse_phone;

    @Basic
    @Column(name = "owner_id_card")
    private String owner_id_card;

    @Basic
    @Column(name = "owner_spouse_id_card")
    private String owner_spouse_id_card;

    @Basic
    @Column(name = "guarantor_name")
    private String guarantor_name;

    @Basic
    @Column(name = "guarantor_phone")
    private String guarantor_phone;

    @Basic
    @Column(name = "guarantor_id_card")
    private String guarantor_id_card;

    @Basic
    @Column(name = "guarantor_company")
    private String guarantor_company;

    @Basic
    @Column(name = "house_address")
    private String house_address;

    @Basic
    @Column(name = "house_certificate_number")
    private String house_certificate_number;

    @Basic
    @Column(name = "house_land_certificate_number")
    private String house_land_certificate_number;

    @Basic
    @Column(name = "house_affiliation")
    private String house_affiliation;

    @Basic
    @Column(name = "house_built_time")
    private String house_built_time;

    @Basic
    @Column(name = "house_type")
    private int house_type;

    @Basic
    @Column(name = "house_area")
    private String house_area;

    @Basic
    @Column(name = "house_land_type")
    private int house_land_type;

    @ManyToOne
    @JoinColumn(name = "loan_bank")
    private Bank loan_bank;

    @ManyToOne
    @JoinColumn(name = "evaluation_company")
    private EvaluateCompany evaluation_company;

    @Basic
    @Column(name = "house_transaction_price")
    private String house_transaction_price;

    @Basic
    @Column(name = "house_evaluate_price")
    private String house_evaluate_price;

    @Basic
    @Column(name = "loan_amount")
    private String loan_amount;

    @Basic
    @Column(name = "loan_period")
    private String loan_period;

    @Basic
    @Column(name = "guarantee_type")
    private String guarantee_type;

    @Basic
    @Column(name = "pay_type")
    private int pay_type;

    @Basic
    @Column(name = "loan_type")
    private int loan_type;

    @Basic
    @Column(name = "down_pay_amount")
    private String down_pay_amount;

    @Basic
    @Column(name = "down_pay_type")
    private String down_pay_type;

    @Basic
    @Column(name = "is_deal_real")
    private boolean is_deal_real;

    @Basic
    @Column(name = "is_client_situation_real")
    private boolean is_client_situation_real;

    @Basic
    @Column(name = "seller_handle")
    private int seller_handle;

    @Basic
    @Column(name = "remark")
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Date finish_time) {
        this.finish_time = finish_time;
    }

    public String getBorrower_name() {
        return borrower_name;
    }

    public void setBorrower_name(String borrower_name) {
        this.borrower_name = borrower_name;
    }

    public String getBorrower_phone() {
        return borrower_phone;
    }

    public void setBorrower_phone(String borrower_phone) {
        this.borrower_phone = borrower_phone;
    }

    public String getBorrower_company() {
        return borrower_company;
    }

    public void setBorrower_company(String borrower_company) {
        this.borrower_company = borrower_company;
    }

    public String getBorrower_company_phone() {
        return borrower_company_phone;
    }

    public void setBorrower_company_phone(String borrower_company_phone) {
        this.borrower_company_phone = borrower_company_phone;
    }

    public String getBorrower_salary() {
        return borrower_salary;
    }

    public void setBorrower_salary(String borrower_salary) {
        this.borrower_salary = borrower_salary;
    }

    public String getBorrower_address() {
        return borrower_address;
    }

    public void setBorrower_address(String borrower_address) {
        this.borrower_address = borrower_address;
    }

    public String getBorrower_resident_city() {
        return borrower_resident_city;
    }

    public void setBorrower_resident_city(String borrower_resident_city) {
        this.borrower_resident_city = borrower_resident_city;
    }

    public String getBorrower_certificate_type() {
        return borrower_certificate_type;
    }

    public void setBorrower_certificate_type(String borrower_certificate_type) {
        this.borrower_certificate_type = borrower_certificate_type;
    }

    public String getBorrower_certificate_number() {
        return borrower_certificate_number;
    }

    public void setBorrower_certificate_number(String borrower_certificate_number) {
        this.borrower_certificate_number = borrower_certificate_number;
    }

    public String getBorrower_spouse_name() {
        return borrower_spouse_name;
    }

    public void setBorrower_spouse_name(String borrower_spouse_name) {
        this.borrower_spouse_name = borrower_spouse_name;
    }

    public String getBorrower_spouse_phone() {
        return borrower_spouse_phone;
    }

    public void setBorrower_spouse_phone(String borrower_spouse_phone) {
        this.borrower_spouse_phone = borrower_spouse_phone;
    }

    public String getBorrower_spouse_company() {
        return borrower_spouse_company;
    }

    public void setBorrower_spouse_company(String borrower_spouse_company) {
        this.borrower_spouse_company = borrower_spouse_company;
    }

    public String getBorrower_spouse_company_phone() {
        return borrower_spouse_company_phone;
    }

    public void setBorrower_spouse_company_phone(String borrower_spouse_company_phone) {
        this.borrower_spouse_company_phone = borrower_spouse_company_phone;
    }

    public String getBorrower_spouse_resident_city() {
        return borrower_spouse_resident_city;
    }

    public void setBorrower_spouse_resident_city(String borrower_spouse_resident_city) {
        this.borrower_spouse_resident_city = borrower_spouse_resident_city;
    }

    public String getBorrower_spouse_certificate_type() {
        return borrower_spouse_certificate_type;
    }

    public void setBorrower_spouse_certificate_type(String borrower_spouse_certificate_type) {
        this.borrower_spouse_certificate_type = borrower_spouse_certificate_type;
    }

    public String getBorrower_spouse_certificate_number() {
        return borrower_spouse_certificate_number;
    }

    public void setBorrower_spouse_certificate_number(String borrower_spouse_certificate_number) {
        this.borrower_spouse_certificate_number = borrower_spouse_certificate_number;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }

    public String getOwner_spouse_name() {
        return owner_spouse_name;
    }

    public void setOwner_spouse_name(String owner_spouse_name) {
        this.owner_spouse_name = owner_spouse_name;
    }

    public String getOwner_spouse_phone() {
        return owner_spouse_phone;
    }

    public void setOwner_spouse_phone(String owner_spouse_phone) {
        this.owner_spouse_phone = owner_spouse_phone;
    }

    public String getOwner_id_card() {
        return owner_id_card;
    }

    public void setOwner_id_card(String owner_id_card) {
        this.owner_id_card = owner_id_card;
    }

    public String getOwner_spouse_id_card() {
        return owner_spouse_id_card;
    }

    public void setOwner_spouse_id_card(String owner_spouse_id_card) {
        this.owner_spouse_id_card = owner_spouse_id_card;
    }

    public String getGuarantor_name() {
        return guarantor_name;
    }

    public void setGuarantor_name(String guarantor_name) {
        this.guarantor_name = guarantor_name;
    }

    public String getGuarantor_phone() {
        return guarantor_phone;
    }

    public void setGuarantor_phone(String guarantor_phone) {
        this.guarantor_phone = guarantor_phone;
    }

    public String getGuarantor_id_card() {
        return guarantor_id_card;
    }

    public void setGuarantor_id_card(String guarantor_id_card) {
        this.guarantor_id_card = guarantor_id_card;
    }

    public String getGuarantor_company() {
        return guarantor_company;
    }

    public void setGuarantor_company(String guarantor_company) {
        this.guarantor_company = guarantor_company;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }

    public String getHouse_certificate_number() {
        return house_certificate_number;
    }

    public void setHouse_certificate_number(String house_certificate_number) {
        this.house_certificate_number = house_certificate_number;
    }

    public String getHouse_land_certificate_number() {
        return house_land_certificate_number;
    }

    public void setHouse_land_certificate_number(String house_land_certificate_number) {
        this.house_land_certificate_number = house_land_certificate_number;
    }

    public String getHouse_affiliation() {
        return house_affiliation;
    }

    public void setHouse_affiliation(String house_affiliation) {
        this.house_affiliation = house_affiliation;
    }

    public String getHouse_built_time() {
        return house_built_time;
    }

    public void setHouse_built_time(String house_built_time) {
        this.house_built_time = house_built_time;
    }

    public int getHouse_type() {
        return house_type;
    }

    public void setHouse_type(int house_type) {
        this.house_type = house_type;
    }

    public String getHouse_area() {
        return house_area;
    }

    public void setHouse_area(String house_area) {
        this.house_area = house_area;
    }

    public int getHouse_land_type() {
        return house_land_type;
    }

    public void setHouse_land_type(int house_land_type) {
        this.house_land_type = house_land_type;
    }

    public Bank getLoan_bank() {
        return loan_bank;
    }

    public void setLoan_bank(Bank loan_bank) {
        this.loan_bank = loan_bank;
    }

    public EvaluateCompany getEvaluation_company() {
        return evaluation_company;
    }

    public void setEvaluation_company(EvaluateCompany evaluation_company) {
        this.evaluation_company = evaluation_company;
    }

    public String getHouse_transaction_price() {
        return house_transaction_price;
    }

    public void setHouse_transaction_price(String house_transaction_price) {
        this.house_transaction_price = house_transaction_price;
    }

    public String getHouse_evaluate_price() {
        return house_evaluate_price;
    }

    public void setHouse_evaluate_price(String house_evaluate_price) {
        this.house_evaluate_price = house_evaluate_price;
    }

    public String getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(String loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getLoan_period() {
        return loan_period;
    }

    public void setLoan_period(String loan_period) {
        this.loan_period = loan_period;
    }

    public String getGuarantee_type() {
        return guarantee_type;
    }

    public void setGuarantee_type(String guarantee_type) {
        this.guarantee_type = guarantee_type;
    }

    public int getPay_type() {
        return pay_type;
    }

    public void setPay_type(int pay_type) {
        this.pay_type = pay_type;
    }

    public int getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(int loan_type) {
        this.loan_type = loan_type;
    }

    public String getDown_pay_amount() {
        return down_pay_amount;
    }

    public void setDown_pay_amount(String down_pay_amount) {
        this.down_pay_amount = down_pay_amount;
    }

    public String getDown_pay_type() {
        return down_pay_type;
    }

    public void setDown_pay_type(String down_pay_type) {
        this.down_pay_type = down_pay_type;
    }

    public boolean isIs_deal_real() {
        return is_deal_real;
    }

    public void setIs_deal_real(boolean is_deal_real) {
        this.is_deal_real = is_deal_real;
    }

    public boolean isIs_client_situation_real() {
        return is_client_situation_real;
    }

    public void setIs_client_situation_real(boolean is_client_situation_real) {
        this.is_client_situation_real = is_client_situation_real;
    }

    public int getSeller_handle() {
        return seller_handle;
    }

    public void setSeller_handle(int seller_handle) {
        this.seller_handle = seller_handle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
