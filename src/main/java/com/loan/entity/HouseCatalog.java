package com.loan.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "loan_house_catalog", schema = "loan")
public class HouseCatalog {
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
    @Column(name = "loan_amount")
    private String loan_amount;

    @Basic
    @Column(name = "clerk_name")
    private String clerk_name;

    @Basic
    @Column(name = "clerk_phone")
    private String clerk_phone;

    @Basic
    @Column(name = "has_client_information")
    private boolean has_client_information;

    @Basic
    @Column(name = "has_both_id_card")
    private boolean has_both_id_card;

    @Basic
    @Column(name = "both_id_card_des")
    private int both_id_card_des;

    @Basic
    @Column(name = "both_id_card_page")
    private String both_id_card_page;

    @Basic
    @Column(name = "both_id_card_remark")
    private String both_id_card_remark;

    @Basic
    @Column(name = "has_both_account")
    private boolean has_both_account;

    @Basic
    @Column(name = "both_account_home")
    private boolean both_account_home;

    @Basic
    @Column(name = "both_account_household")
    private boolean both_account_household;

    @Basic
    @Column(name = "both_account_myself")
    private boolean both_account_myself;

    @Basic
    @Column(name = "both_account_des")
    private int both_account_des;

    @Basic
    @Column(name = "both_account_page")
    private String both_account_page;

    @Basic
    @Column(name = "both_account_remark")
    private String both_account_remark;

    @Basic
    @Column(name = "has_marriage_proof")
    private boolean has_marriage_proof;

    @Basic
    @Column(name = "marriage_certificate")
    private boolean marriage_certificate;

    @Basic
    @Column(name = "divorce_certificate")
    private boolean divorce_certificate;

    @Basic
    @Column(name = "divorce_agreement")
    private boolean divorce_agreement;

    @Basic
    @Column(name = "marriage_proof_des")
    private int marriage_proof_des;

    @Basic
    @Column(name = "marriage_proof_page")
    private String marriage_proof_page;

    @Basic
    @Column(name = "marriage_proof_remark")
    private String marriage_proof_remark;

    @Basic
    @Column(name = "has_house_certificate")
    private boolean has_house_certificate;

    @Basic
    @Column(name = "house_certificate_des")
    private int house_certificate_des;

    @Basic
    @Column(name = "house_certificate_page")
    private String house_certificate_page;

    @Basic
    @Column(name = "house_certificate_remark")
    private String house_certificate_remark;

    @Basic
    @Column(name = "has_pay_receipt")
    private boolean has_pay_receipt;

    @Basic
    @Column(name = "pay_receipt_des")
    private int pay_receipt_des;

    @Basic
    @Column(name = "pay_receipt_page")
    private String pay_receipt_page;

    @Basic
    @Column(name = "pay_receipt_remark")
    private String pay_receipt_remark;

    @Basic
    @Column(name = "has_bank_card")
    private boolean has_bank_card;

    @Basic
    @Column(name = "bank_card_des")
    private int bank_card_des;

    @Basic
    @Column(name = "bank_card_page")
    private String bank_card_page;

    @Basic
    @Column(name = "bank_card_remark")
    private String bank_card_remark;

    @Basic
    @Column(name = "has_salary_proof")
    private boolean has_salary_proof;

    @Basic
    @Column(name = "salary_proof_des")
    private int salary_proof_des;

    @Basic
    @Column(name = "salary_proof_page")
    private String salary_proof_page;

    @Basic
    @Column(name = "salary_proof_remark")
    private String salary_proof_remark;

    @Basic
    @Column(name = "has_bank_statement")
    private boolean has_bank_statement;

    @Basic
    @Column(name = "bank_statement_des")
    private int bank_statement_des;

    @Basic
    @Column(name = "bank_statement_page")
    private String bank_statement_page;

    @Basic
    @Column(name = "bank_statement_remark")
    private String bank_statement_remark;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog")
    private List<HouseCatalogOther> houseCatalogOthers = new ArrayList<>();

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

    public String getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(String loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getClerk_name() {
        return clerk_name;
    }

    public void setClerk_name(String clerk_name) {
        this.clerk_name = clerk_name;
    }

    public String getClerk_phone() {
        return clerk_phone;
    }

    public void setClerk_phone(String clerk_phone) {
        this.clerk_phone = clerk_phone;
    }

    public boolean isHas_client_information() {
        return has_client_information;
    }

    public void setHas_client_information(boolean has_client_information) {
        this.has_client_information = has_client_information;
    }

    public boolean isHas_both_id_card() {
        return has_both_id_card;
    }

    public void setHas_both_id_card(boolean has_both_id_card) {
        this.has_both_id_card = has_both_id_card;
    }

    public int getBoth_id_card_des() {
        return both_id_card_des;
    }

    public void setBoth_id_card_des(int both_id_card_des) {
        this.both_id_card_des = both_id_card_des;
    }

    public String getBoth_id_card_page() {
        return both_id_card_page;
    }

    public void setBoth_id_card_page(String both_id_card_page) {
        this.both_id_card_page = both_id_card_page;
    }

    public String getBoth_id_card_remark() {
        return both_id_card_remark;
    }

    public void setBoth_id_card_remark(String both_id_card_remark) {
        this.both_id_card_remark = both_id_card_remark;
    }

    public boolean isHas_both_account() {
        return has_both_account;
    }

    public void setHas_both_account(boolean has_both_account) {
        this.has_both_account = has_both_account;
    }

    public boolean isBoth_account_home() {
        return both_account_home;
    }

    public void setBoth_account_home(boolean both_account_home) {
        this.both_account_home = both_account_home;
    }

    public boolean isBoth_account_household() {
        return both_account_household;
    }

    public void setBoth_account_household(boolean both_account_household) {
        this.both_account_household = both_account_household;
    }

    public boolean isBoth_account_myself() {
        return both_account_myself;
    }

    public void setBoth_account_myself(boolean both_account_myself) {
        this.both_account_myself = both_account_myself;
    }

    public int getBoth_account_des() {
        return both_account_des;
    }

    public void setBoth_account_des(int both_account_des) {
        this.both_account_des = both_account_des;
    }

    public String getBoth_account_page() {
        return both_account_page;
    }

    public void setBoth_account_page(String both_account_page) {
        this.both_account_page = both_account_page;
    }

    public String getBoth_account_remark() {
        return both_account_remark;
    }

    public void setBoth_account_remark(String both_account_remark) {
        this.both_account_remark = both_account_remark;
    }

    public boolean isHas_marriage_proof() {
        return has_marriage_proof;
    }

    public void setHas_marriage_proof(boolean has_marriage_proof) {
        this.has_marriage_proof = has_marriage_proof;
    }

    public boolean isMarriage_certificate() {
        return marriage_certificate;
    }

    public void setMarriage_certificate(boolean marriage_certificate) {
        this.marriage_certificate = marriage_certificate;
    }

    public boolean isDivorce_certificate() {
        return divorce_certificate;
    }

    public void setDivorce_certificate(boolean divorce_certificate) {
        this.divorce_certificate = divorce_certificate;
    }

    public boolean isDivorce_agreement() {
        return divorce_agreement;
    }

    public void setDivorce_agreement(boolean divorce_agreement) {
        this.divorce_agreement = divorce_agreement;
    }

    public int getMarriage_proof_des() {
        return marriage_proof_des;
    }

    public void setMarriage_proof_des(int marriage_proof_des) {
        this.marriage_proof_des = marriage_proof_des;
    }

    public String getMarriage_proof_page() {
        return marriage_proof_page;
    }

    public void setMarriage_proof_page(String marriage_proof_page) {
        this.marriage_proof_page = marriage_proof_page;
    }

    public String getMarriage_proof_remark() {
        return marriage_proof_remark;
    }

    public void setMarriage_proof_remark(String marriage_proof_remark) {
        this.marriage_proof_remark = marriage_proof_remark;
    }

    public boolean isHas_house_certificate() {
        return has_house_certificate;
    }

    public void setHas_house_certificate(boolean has_house_certificate) {
        this.has_house_certificate = has_house_certificate;
    }

    public int getHouse_certificate_des() {
        return house_certificate_des;
    }

    public void setHouse_certificate_des(int house_certificate_des) {
        this.house_certificate_des = house_certificate_des;
    }

    public String getHouse_certificate_page() {
        return house_certificate_page;
    }

    public void setHouse_certificate_page(String house_certificate_page) {
        this.house_certificate_page = house_certificate_page;
    }

    public String getHouse_certificate_remark() {
        return house_certificate_remark;
    }

    public void setHouse_certificate_remark(String house_certificate_remark) {
        this.house_certificate_remark = house_certificate_remark;
    }

    public boolean isHas_pay_receipt() {
        return has_pay_receipt;
    }

    public void setHas_pay_receipt(boolean has_pay_receipt) {
        this.has_pay_receipt = has_pay_receipt;
    }

    public int getPay_receipt_des() {
        return pay_receipt_des;
    }

    public void setPay_receipt_des(int pay_receipt_des) {
        this.pay_receipt_des = pay_receipt_des;
    }

    public String getPay_receipt_page() {
        return pay_receipt_page;
    }

    public void setPay_receipt_page(String pay_receipt_page) {
        this.pay_receipt_page = pay_receipt_page;
    }

    public String getPay_receipt_remark() {
        return pay_receipt_remark;
    }

    public void setPay_receipt_remark(String pay_receipt_remark) {
        this.pay_receipt_remark = pay_receipt_remark;
    }

    public boolean isHas_bank_card() {
        return has_bank_card;
    }

    public void setHas_bank_card(boolean has_bank_card) {
        this.has_bank_card = has_bank_card;
    }

    public int getBank_card_des() {
        return bank_card_des;
    }

    public void setBank_card_des(int bank_card_des) {
        this.bank_card_des = bank_card_des;
    }

    public String getBank_card_page() {
        return bank_card_page;
    }

    public void setBank_card_page(String bank_card_page) {
        this.bank_card_page = bank_card_page;
    }

    public String getBank_card_remark() {
        return bank_card_remark;
    }

    public void setBank_card_remark(String bank_card_remark) {
        this.bank_card_remark = bank_card_remark;
    }

    public boolean isHas_salary_proof() {
        return has_salary_proof;
    }

    public void setHas_salary_proof(boolean has_salary_proof) {
        this.has_salary_proof = has_salary_proof;
    }

    public int getSalary_proof_des() {
        return salary_proof_des;
    }

    public void setSalary_proof_des(int salary_proof_des) {
        this.salary_proof_des = salary_proof_des;
    }

    public String getSalary_proof_page() {
        return salary_proof_page;
    }

    public void setSalary_proof_page(String salary_proof_page) {
        this.salary_proof_page = salary_proof_page;
    }

    public String getSalary_proof_remark() {
        return salary_proof_remark;
    }

    public void setSalary_proof_remark(String salary_proof_remark) {
        this.salary_proof_remark = salary_proof_remark;
    }

    public boolean isHas_bank_statement() {
        return has_bank_statement;
    }

    public void setHas_bank_statement(boolean has_bank_statement) {
        this.has_bank_statement = has_bank_statement;
    }

    public int getBank_statement_des() {
        return bank_statement_des;
    }

    public void setBank_statement_des(int bank_statement_des) {
        this.bank_statement_des = bank_statement_des;
    }

    public String getBank_statement_page() {
        return bank_statement_page;
    }

    public void setBank_statement_page(String bank_statement_page) {
        this.bank_statement_page = bank_statement_page;
    }

    public String getBank_statement_remark() {
        return bank_statement_remark;
    }

    public void setBank_statement_remark(String bank_statement_remark) {
        this.bank_statement_remark = bank_statement_remark;
    }

    public List<HouseCatalogOther> getHouseCatalogOthers() {
        return houseCatalogOthers;
    }

    public void setHouseCatalogOthers(List<HouseCatalogOther> houseCatalogOthers) {
        this.houseCatalogOthers = houseCatalogOthers;
    }
}
