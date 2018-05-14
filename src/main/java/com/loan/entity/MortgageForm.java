package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_mortgage_form", schema = "loan")
public class MortgageForm {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "application_time")
    private Date application_time;

    @Basic
    @Column(name = "proposer_name")
    private String proposer_name;

    @Basic
    @Column(name = "proposer_gender")
    private int proposer_gender;

    @Basic
    @Column(name = "proposer_marriage_state")
    private int proposer_marriage_state;

    @Basic
    @Column(name = "proposer_family")
    private int proposer_family;

    @Basic
    @Column(name = "proposer_family_num")
    private int proposer_family_num;

    @Basic
    @Column(name = "proposer_phone")
    private String proposer_phone;

    @Basic
    @Column(name = "proposer_work_tele")
    private String proposer_work_tele;

    @Basic
    @Column(name = "proposer_house_tele")
    private String proposer_house_tele;

    @Basic
    @Column(name = "proposer_household_type")
    private int proposer_household_type;

    @Basic
    @Column(name = "proposer_id_card")
    private String proposer_id_card;

    @Basic
    @Column(name = "proposer_inhabiting_info")
    private String proposer_inhabiting_info;

    @Basic
    @Column(name = "proposer_address")
    private String proposer_address;

    @Basic
    @Column(name = "proposer_local_resident")
    private String proposer_local_resident;

    @Basic
    @Column(name = "proposer_lodging_info")
    private int proposer_lodging_info;

    @Basic
    @Column(name = "proposer_loan_state")
    private int proposer_loan_state;

    @Basic
    @Column(name = "proposer_job_type")
    private int proposer_job_type;

    @Basic
    @Column(name = "proposer_work_year")
    private String proposer_work_year;

    @Basic
    @Column(name = "proposer_income_month")
    private String proposer_income_month;

    @Basic
    @Column(name = "proposer_spouse_name")
    private String proposer_spouse_name;

    @Basic
    @Column(name = "proposer_spouse_phone")
    private String proposer_spouse_phone;

    @Basic
    @Column(name = "proposer_spouse_paper_type")
    private int proposer_spouse_paper_type;

    @Basic
    @Column(name = "proposer_spouse_paper_id")
    private String proposer_spouse_paper_id;

    @Basic
    @Column(name = "has_proposer_spouse_together")
    private boolean has_proposer_spouse_together;

    @Basic
    @Column(name = "proposer_company")
    private String proposer_company;

    @Basic
    @Column(name = "proposer_company_address")
    private String proposer_company_address;

    @Basic
    @Column(name = "proposer_company_type")
    private int proposer_company_type;

    @Basic
    @Column(name = "proposer_company_duty")
    private int proposer_company_duty;

    @Basic
    @Column(name = "proposer_business_license")
    private String proposer_business_license;

    @Basic
    @Column(name = "proposer_business_address")
    private String proposer_business_address;

    @Basic
    @Column(name = "proposer_business")
    private String proposer_business;

    @Basic
    @Column(name = "proposer_business_card")
    private String proposer_business_card;

    @Basic
    @Column(name = "loan_amount")
    private String loan_amount;

    @Basic
    @Column(name = "loan_period")
    private String loan_period;

    @Basic
    @Column(name = "loan_credit_type")
    private int loan_credit_type;

    @Basic
    @Column(name = "loan_purpose")
    private String loan_purpose;

    @Basic
    @Column(name = "loan_repayment_type")
    private int loan_repayment_type;

    @Basic
    @Column(name = "loan_other")
    private String loan_other;

    @Basic
    @Column(name = "loan_contact_name")
    private String loan_contact_name;

    @Basic
    @Column(name = "loan_contact_rela")
    private int loan_contact_rela;

    @Basic
    @Column(name = "loan_contact_tele")
    private String loan_contact_tele;

    @Basic
    @Column(name = "loan_contact_phone")
    private String loan_contact_phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getApplication_time() {
        return application_time;
    }

    public void setApplication_time(Date application_time) {
        this.application_time = application_time;
    }

    public String getProposer_name() {
        return proposer_name;
    }

    public void setProposer_name(String proposer_name) {
        this.proposer_name = proposer_name;
    }

    public int getProposer_gender() {
        return proposer_gender;
    }

    public void setProposer_gender(int proposer_gender) {
        this.proposer_gender = proposer_gender;
    }

    public int getProposer_marriage_state() {
        return proposer_marriage_state;
    }

    public void setProposer_marriage_state(int proposer_marriage_state) {
        this.proposer_marriage_state = proposer_marriage_state;
    }

    public int getProposer_family() {
        return proposer_family;
    }

    public void setProposer_family(int proposer_family) {
        this.proposer_family = proposer_family;
    }

    public int getProposer_family_num() {
        return proposer_family_num;
    }

    public void setProposer_family_num(int proposer_family_num) {
        this.proposer_family_num = proposer_family_num;
    }

    public String getProposer_phone() {
        return proposer_phone;
    }

    public void setProposer_phone(String proposer_phone) {
        this.proposer_phone = proposer_phone;
    }

    public String getProposer_work_tele() {
        return proposer_work_tele;
    }

    public void setProposer_work_tele(String proposer_work_tele) {
        this.proposer_work_tele = proposer_work_tele;
    }

    public String getProposer_house_tele() {
        return proposer_house_tele;
    }

    public void setProposer_house_tele(String proposer_house_tele) {
        this.proposer_house_tele = proposer_house_tele;
    }

    public int getProposer_household_type() {
        return proposer_household_type;
    }

    public void setProposer_household_type(int proposer_household_type) {
        this.proposer_household_type = proposer_household_type;
    }

    public String getProposer_id_card() {
        return proposer_id_card;
    }

    public void setProposer_id_card(String proposer_id_card) {
        this.proposer_id_card = proposer_id_card;
    }

    public String getProposer_inhabiting_info() {
        return proposer_inhabiting_info;
    }

    public void setProposer_inhabiting_info(String proposer_inhabiting_info) {
        this.proposer_inhabiting_info = proposer_inhabiting_info;
    }

    public String getProposer_address() {
        return proposer_address;
    }

    public void setProposer_address(String proposer_address) {
        this.proposer_address = proposer_address;
    }

    public String getProposer_local_resident() {
        return proposer_local_resident;
    }

    public void setProposer_local_resident(String proposer_local_resident) {
        this.proposer_local_resident = proposer_local_resident;
    }

    public int getProposer_lodging_info() {
        return proposer_lodging_info;
    }

    public void setProposer_lodging_info(int proposer_lodging_info) {
        this.proposer_lodging_info = proposer_lodging_info;
    }

    public int getProposer_loan_state() {
        return proposer_loan_state;
    }

    public void setProposer_loan_state(int proposer_loan_state) {
        this.proposer_loan_state = proposer_loan_state;
    }

    public int getProposer_job_type() {
        return proposer_job_type;
    }

    public void setProposer_job_type(int proposer_job_type) {
        this.proposer_job_type = proposer_job_type;
    }

    public String getProposer_work_year() {
        return proposer_work_year;
    }

    public void setProposer_work_year(String proposer_work_year) {
        this.proposer_work_year = proposer_work_year;
    }

    public String getProposer_income_month() {
        return proposer_income_month;
    }

    public void setProposer_income_month(String proposer_income_month) {
        this.proposer_income_month = proposer_income_month;
    }

    public String getProposer_spouse_name() {
        return proposer_spouse_name;
    }

    public void setProposer_spouse_name(String proposer_spouse_name) {
        this.proposer_spouse_name = proposer_spouse_name;
    }

    public String getProposer_spouse_phone() {
        return proposer_spouse_phone;
    }

    public void setProposer_spouse_phone(String proposer_spouse_phone) {
        this.proposer_spouse_phone = proposer_spouse_phone;
    }

    public int getProposer_spouse_paper_type() {
        return proposer_spouse_paper_type;
    }

    public void setProposer_spouse_paper_type(int proposer_spouse_paper_type) {
        this.proposer_spouse_paper_type = proposer_spouse_paper_type;
    }

    public String getProposer_spouse_paper_id() {
        return proposer_spouse_paper_id;
    }

    public void setProposer_spouse_paper_id(String proposer_spouse_paper_id) {
        this.proposer_spouse_paper_id = proposer_spouse_paper_id;
    }

    public boolean isHas_proposer_spouse_together() {
        return has_proposer_spouse_together;
    }

    public void setHas_proposer_spouse_together(boolean has_proposer_spouse_together) {
        this.has_proposer_spouse_together = has_proposer_spouse_together;
    }

    public String getProposer_company() {
        return proposer_company;
    }

    public void setProposer_company(String proposer_company) {
        this.proposer_company = proposer_company;
    }

    public String getProposer_company_address() {
        return proposer_company_address;
    }

    public void setProposer_company_address(String proposer_company_address) {
        this.proposer_company_address = proposer_company_address;
    }

    public int getProposer_company_type() {
        return proposer_company_type;
    }

    public void setProposer_company_type(int proposer_company_type) {
        this.proposer_company_type = proposer_company_type;
    }

    public int getProposer_company_duty() {
        return proposer_company_duty;
    }

    public void setProposer_company_duty(int proposer_company_duty) {
        this.proposer_company_duty = proposer_company_duty;
    }

    public String getProposer_business_license() {
        return proposer_business_license;
    }

    public void setProposer_business_license(String proposer_business_license) {
        this.proposer_business_license = proposer_business_license;
    }

    public String getProposer_business_address() {
        return proposer_business_address;
    }

    public void setProposer_business_address(String proposer_business_address) {
        this.proposer_business_address = proposer_business_address;
    }

    public String getProposer_business() {
        return proposer_business;
    }

    public void setProposer_business(String proposer_business) {
        this.proposer_business = proposer_business;
    }

    public String getProposer_business_card() {
        return proposer_business_card;
    }

    public void setProposer_business_card(String proposer_business_card) {
        this.proposer_business_card = proposer_business_card;
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

    public int getLoan_credit_type() {
        return loan_credit_type;
    }

    public void setLoan_credit_type(int loan_credit_type) {
        this.loan_credit_type = loan_credit_type;
    }

    public String getLoan_purpose() {
        return loan_purpose;
    }

    public void setLoan_purpose(String loan_purpose) {
        this.loan_purpose = loan_purpose;
    }

    public int getLoan_repayment_type() {
        return loan_repayment_type;
    }

    public void setLoan_repayment_type(int loan_repayment_type) {
        this.loan_repayment_type = loan_repayment_type;
    }

    public String getLoan_other() {
        return loan_other;
    }

    public void setLoan_other(String loan_other) {
        this.loan_other = loan_other;
    }

    public String getLoan_contact_name() {
        return loan_contact_name;
    }

    public void setLoan_contact_name(String loan_contact_name) {
        this.loan_contact_name = loan_contact_name;
    }

    public int getLoan_contact_rela() {
        return loan_contact_rela;
    }

    public void setLoan_contact_rela(int loan_contact_rela) {
        this.loan_contact_rela = loan_contact_rela;
    }

    public String getLoan_contact_tele() {
        return loan_contact_tele;
    }

    public void setLoan_contact_tele(String loan_contact_tele) {
        this.loan_contact_tele = loan_contact_tele;
    }

    public String getLoan_contact_phone() {
        return loan_contact_phone;
    }

    public void setLoan_contact_phone(String loan_contact_phone) {
        this.loan_contact_phone = loan_contact_phone;
    }
}
