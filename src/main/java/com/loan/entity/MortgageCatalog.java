package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_mortgage_catalogs", schema = "loan")
public class MortgageCatalog {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "finish_time")
    private Date finish_time;

    @Basic
    @Column(name = "client_name")
    private String client_name;

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
    @Column(name = "has_client_id_card")
    private boolean has_client_id_card;

    @Basic
    @Column(name = "client_id_card_dpr")
    private String client_id_card_dpr;

    @Basic
    @Column(name = "has_client_account")
    private boolean has_client_account;

    @Basic
    @Column(name = "client_account")
    private String client_account;

    @Basic
    @Column(name = "client_account_dpr")
    private String client_account_dpr;

    @Basic
    @Column(name = "has_client_spouse_id_card")
    private boolean has_client_spouse_id_card;

    @Basic
    @Column(name = "client_spouse_id_card_dpr")
    private String client_spouse_id_card_dpr;

    @Basic
    @Column(name = "has_client_spouse_account")
    private boolean has_client_spouse_account;

    @Basic
    @Column(name = "client_spouse_account")
    private String client_spouse_account;

    @Basic
    @Column(name = "client_spouse_account_dpr")
    private String client_spouse_account_dpr;

    @Basic
    @Column(name = "has_marriage_proof")
    private boolean has_marriage_proof;

    @Basic
    @Column(name = "marriage_proof")
    private String marriage_proof;

    @Basic
    @Column(name = "marriage_proof_dpr")
    private String marriage_proof_dpr;

    @Basic
    @Column(name = "has_house_mortgage")
    private boolean has_house_mortgage;

    @Basic
    @Column(name = "house_mortgage")
    private String house_mortgage;

    @Basic
    @Column(name = "house_mortgage_dpr")
    private String house_mortgage_dpr;

    @Basic
    @Column(name = "has_assets_certification")
    private boolean has_assets_certification;

    @Basic
    @Column(name = "assets_certification")
    private String assets_certification;

    @Basic
    @Column(name = "assets_certification_dpr")
    private String assets_certification_dpr;

    @Basic
    @Column(name = "has_income_proof")
    private boolean has_income_proof;

    @Basic
    @Column(name = "income_proof_dpr")
    private String income_proof_dpr;

    @Basic
    @Column(name = "has_business_license")
    private boolean has_business_license;

    @Basic
    @Column(name = "business_license_dpr")
    private String business_license_dpr;

    @Basic
    @Column(name = "has_legal_representative")
    private boolean has_legal_representative;

    @Basic
    @Column(name = "legal_representative_dpr")
    private String legal_representative_dpr;

    @Basic
    @Column(name = "has_company_statute")
    private boolean has_company_statute;

    @Basic
    @Column(name = "company_statute_dpr")
    private String company_statute_dpr;

    @Basic
    @Column(name = "has_grant_deed")
    private boolean has_grant_deed;

    @Basic
    @Column(name = "grant_deed_dpr")
    private String grant_deed_dpr;

    @Basic
    @Column(name = "has_trading_contact")
    private boolean has_trading_contact;

    @Basic
    @Column(name = "trading_contact_dpr")
    private String trading_contact_dpr;

    @Basic
    @Column(name = "has_purpose_contact")
    private boolean has_purpose_contact;

    @Basic
    @Column(name = "purpose_contact_dpr")
    private String purpose_contact_dpr;

    @Basic
    @Column(name = "has_other")
    private boolean has_other;

    @Basic
    @Column(name = "other_dpr")
    private String other_dpr;

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

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
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

    public boolean isHas_client_id_card() {
        return has_client_id_card;
    }

    public void setHas_client_id_card(boolean has_client_id_card) {
        this.has_client_id_card = has_client_id_card;
    }

    public String getClient_id_card_dpr() {
        return client_id_card_dpr;
    }

    public void setClient_id_card_dpr(String client_id_card_dpr) {
        this.client_id_card_dpr = client_id_card_dpr;
    }

    public boolean isHas_client_account() {
        return has_client_account;
    }

    public void setHas_client_account(boolean has_client_account) {
        this.has_client_account = has_client_account;
    }

    public String getClient_account() {
        return client_account;
    }

    public void setClient_account(String client_account) {
        this.client_account = client_account;
    }

    public String getClient_account_dpr() {
        return client_account_dpr;
    }

    public void setClient_account_dpr(String client_account_dpr) {
        this.client_account_dpr = client_account_dpr;
    }

    public boolean isHas_client_spouse_id_card() {
        return has_client_spouse_id_card;
    }

    public void setHas_client_spouse_id_card(boolean has_client_spouse_id_card) {
        this.has_client_spouse_id_card = has_client_spouse_id_card;
    }

    public String getClient_spouse_id_card_dpr() {
        return client_spouse_id_card_dpr;
    }

    public void setClient_spouse_id_card_dpr(String client_spouse_id_card_dpr) {
        this.client_spouse_id_card_dpr = client_spouse_id_card_dpr;
    }

    public boolean isHas_client_spouse_account() {
        return has_client_spouse_account;
    }

    public void setHas_client_spouse_account(boolean has_client_spouse_account) {
        this.has_client_spouse_account = has_client_spouse_account;
    }

    public String getClient_spouse_account() {
        return client_spouse_account;
    }

    public void setClient_spouse_account(String client_spouse_account) {
        this.client_spouse_account = client_spouse_account;
    }

    public String getClient_spouse_account_dpr() {
        return client_spouse_account_dpr;
    }

    public void setClient_spouse_account_dpr(String client_spouse_account_dpr) {
        this.client_spouse_account_dpr = client_spouse_account_dpr;
    }

    public boolean isHas_marriage_proof() {
        return has_marriage_proof;
    }

    public void setHas_marriage_proof(boolean has_marriage_proof) {
        this.has_marriage_proof = has_marriage_proof;
    }

    public String getMarriage_proof() {
        return marriage_proof;
    }

    public void setMarriage_proof(String marriage_proof) {
        this.marriage_proof = marriage_proof;
    }

    public String getMarriage_proof_dpr() {
        return marriage_proof_dpr;
    }

    public void setMarriage_proof_dpr(String marriage_proof_dpr) {
        this.marriage_proof_dpr = marriage_proof_dpr;
    }

    public boolean isHas_house_mortgage() {
        return has_house_mortgage;
    }

    public void setHas_house_mortgage(boolean has_house_mortgage) {
        this.has_house_mortgage = has_house_mortgage;
    }

    public String getHouse_mortgage() {
        return house_mortgage;
    }

    public void setHouse_mortgage(String house_mortgage) {
        this.house_mortgage = house_mortgage;
    }

    public String getHouse_mortgage_dpr() {
        return house_mortgage_dpr;
    }

    public void setHouse_mortgage_dpr(String house_mortgage_dpr) {
        this.house_mortgage_dpr = house_mortgage_dpr;
    }

    public boolean isHas_assets_certification() {
        return has_assets_certification;
    }

    public void setHas_assets_certification(boolean has_assets_certification) {
        this.has_assets_certification = has_assets_certification;
    }

    public String getAssets_certification() {
        return assets_certification;
    }

    public void setAssets_certification(String assets_certification) {
        this.assets_certification = assets_certification;
    }

    public String getAssets_certification_dpr() {
        return assets_certification_dpr;
    }

    public void setAssets_certification_dpr(String assets_certification_dpr) {
        this.assets_certification_dpr = assets_certification_dpr;
    }

    public boolean isHas_income_proof() {
        return has_income_proof;
    }

    public void setHas_income_proof(boolean has_income_proof) {
        this.has_income_proof = has_income_proof;
    }

    public String getIncome_proof_dpr() {
        return income_proof_dpr;
    }

    public void setIncome_proof_dpr(String income_proof_dpr) {
        this.income_proof_dpr = income_proof_dpr;
    }

    public boolean isHas_business_license() {
        return has_business_license;
    }

    public void setHas_business_license(boolean has_business_license) {
        this.has_business_license = has_business_license;
    }

    public String getBusiness_license_dpr() {
        return business_license_dpr;
    }

    public void setBusiness_license_dpr(String business_license_dpr) {
        this.business_license_dpr = business_license_dpr;
    }

    public boolean isHas_legal_representative() {
        return has_legal_representative;
    }

    public void setHas_legal_representative(boolean has_legal_representative) {
        this.has_legal_representative = has_legal_representative;
    }

    public String getLegal_representative_dpr() {
        return legal_representative_dpr;
    }

    public void setLegal_representative_dpr(String legal_representative_dpr) {
        this.legal_representative_dpr = legal_representative_dpr;
    }

    public boolean isHas_company_statute() {
        return has_company_statute;
    }

    public void setHas_company_statute(boolean has_company_statute) {
        this.has_company_statute = has_company_statute;
    }

    public String getCompany_statute_dpr() {
        return company_statute_dpr;
    }

    public void setCompany_statute_dpr(String company_statute_dpr) {
        this.company_statute_dpr = company_statute_dpr;
    }

    public boolean isHas_grant_deed() {
        return has_grant_deed;
    }

    public void setHas_grant_deed(boolean has_grant_deed) {
        this.has_grant_deed = has_grant_deed;
    }

    public String getGrant_deed_dpr() {
        return grant_deed_dpr;
    }

    public void setGrant_deed_dpr(String grant_deed_dpr) {
        this.grant_deed_dpr = grant_deed_dpr;
    }

    public boolean isHas_trading_contact() {
        return has_trading_contact;
    }

    public void setHas_trading_contact(boolean has_trading_contact) {
        this.has_trading_contact = has_trading_contact;
    }

    public String getTrading_contact_dpr() {
        return trading_contact_dpr;
    }

    public void setTrading_contact_dpr(String trading_contact_dpr) {
        this.trading_contact_dpr = trading_contact_dpr;
    }

    public boolean isHas_purpose_contact() {
        return has_purpose_contact;
    }

    public void setHas_purpose_contact(boolean has_purpose_contact) {
        this.has_purpose_contact = has_purpose_contact;
    }

    public String getPurpose_contact_dpr() {
        return purpose_contact_dpr;
    }

    public void setPurpose_contact_dpr(String purpose_contact_dpr) {
        this.purpose_contact_dpr = purpose_contact_dpr;
    }

    public boolean isHas_other() {
        return has_other;
    }

    public void setHas_other(boolean has_other) {
        this.has_other = has_other;
    }

    public String getOther_dpr() {
        return other_dpr;
    }

    public void setOther_dpr(String other_dpr) {
        this.other_dpr = other_dpr;
    }
}
