package com.loan.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "loan_mortgage_catalog", schema = "loan")
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
    @Column(name = "client_id_card_des")
    private int client_id_card_des;

    @Basic
    @Column(name = "client_id_card_page")
    private String client_id_card_page;

    @Basic
    @Column(name = "client_id_card_remark")
    private String client_id_card_remark;

    @Basic
    @Column(name = "has_client_account")
    private boolean has_client_account;

    @Basic
    @Column(name = "client_account_home")
    private boolean client_account_home;

    @Basic
    @Column(name = "client_account_household")
    private boolean client_account_household;

    @Basic
    @Column(name = "client_account_myself")
    private boolean client_account_myself;

    @Basic
    @Column(name = "client_account_des")
    private int client_account_des;

    @Basic
    @Column(name = "client_account_page")
    private String client_account_page;

    @Basic
    @Column(name = "client_account_remark")
    private String client_account_remark;

    @Basic
    @Column(name = "has_client_spouse_id_card")
    private boolean has_client_spouse_id_card;

    @Basic
    @Column(name = "client_spouse_id_card_des")
    private int client_spouse_id_card_des;

    @Basic
    @Column(name = "client_spouse_id_card_page")
    private String client_spouse_id_card_page;

    @Basic
    @Column(name = "client_spouse_id_card_remark")
    private String client_spouse_id_card_remark;

    @Basic
    @Column(name = "has_client_spouse_account")
    private boolean has_client_spouse_account;

    @Basic
    @Column(name = "client_spouse_account_home")
    private boolean client_spouse_account_home;

    @Basic
    @Column(name = "client_spouse_account_household")
    private boolean client_spouse_account_household;

    @Basic
    @Column(name = "client_spouse_account_myself")
    private boolean client_spouse_account_myself;

    @Basic
    @Column(name = "client_spouse_account_des")
    private int client_spouse_account_des;

    @Basic
    @Column(name = "client_spouse_account_page")
    private String client_spouse_account_page;

    @Basic
    @Column(name = "client_spouse_account_remark")
    private String client_spouse_account_remark;

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
    private String marriage_proof_des;

    @Basic
    @Column(name = "marriage_proof_page")
    private String marriage_proof_page;

    @Basic
    @Column(name = "marriage_proof_remark")
    private String marriage_proof_remark;

    @Basic
    @Column(name = "has_house_mortgage")
    private boolean has_house_mortgage;

    @Basic
    @Column(name = "house_mortgage")
    private String house_mortgage;

    @Basic
    @Column(name = "house_mortgage_des")
    private int house_mortgage_des;

    @Basic
    @Column(name = "house_mortgage_page")
    private String house_mortgage_page;

    @Basic
    @Column(name = "house_mortgage_remark")
    private String house_mortgage_remark;

    @Basic
    @Column(name = "has_assets_certificate")
    private boolean has_assets_certificate;

    @Basic
    @Column(name = "assets_house_certificate")
    private boolean assets_house_certificate;

    @Basic
    @Column(name = "assets_house_number")
    private String assets_house_number;

    @Basic
    @Column(name = "assets_other")
    private boolean assets_other;

    @Basic
    @Column(name = "assets_other_remark")
    private String assets_other_remark;

    @Basic
    @Column(name = "assets_car_certificate")
    private boolean assets_car_certificate;

    @Basic
    @Column(name = "assets_car_number")
    private String assets_car_number;

    @Basic
    @Column(name = "assets_certificate_des")
    private int assets_certificate_des;

    @Basic
    @Column(name = "assets_certificate_page")
    private String assets_certificate_page;

    @Basic
    @Column(name = "assets_certificate_remark")
    private String assets_certificate_remark;

    @Basic
    @Column(name = "has_income_proof")
    private boolean has_income_proof;

    @Basic
    @Column(name = "income_proof_des")
    private int income_proof_des;

    @Basic
    @Column(name = "income_proof_page")
    private String income_proof_page;

    @Basic
    @Column(name = "income_proof_remark")
    private String income_proof_remark;

    @Basic
    @Column(name = "has_business_license")
    private boolean has_business_license;

    @Basic
    @Column(name = "business_license_des")
    private int business_license_des;

    @Basic
    @Column(name = "business_license_page")
    private String business_license_page;

    @Basic
    @Column(name = "business_license_remark")
    private String business_license_remark;

    @Basic
    @Column(name = "has_legal_representative")
    private boolean has_legal_representative;

    @Basic
    @Column(name = "legal_representative_des")
    private int legal_representative_des;

    @Basic
    @Column(name = "legal_representative_page")
    private String legal_representative_page;

    @Basic
    @Column(name = "legal_representative_remark")
    private String legal_representative_remark;

    @Basic
    @Column(name = "has_company_statute")
    private boolean has_company_statute;

    @Basic
    @Column(name = "company_statute_des")
    private int company_statute_des;

    @Basic
    @Column(name = "company_statute_page")
    private String company_statute_page;

    @Basic
    @Column(name = "company_statute_remark")
    private String company_statute_remark;

    @Basic
    @Column(name = "has_grant_deed")
    private boolean has_grant_deed;

    @Basic
    @Column(name = "grant_deed_des")
    private int grant_deed_des;

    @Basic
    @Column(name = "grant_deed_page")
    private String grant_deed_page;

    @Basic
    @Column(name = "grant_deed_remark")
    private String grant_deed_remark;

    @Basic
    @Column(name = "has_trading_contact")
    private boolean has_trading_contact;

    @Basic
    @Column(name = "trading_contact_des")
    private int trading_contact_des;

    @Basic
    @Column(name = "trading_contact_page")
    private String trading_contact_page;

    @Basic
    @Column(name = "trading_contact_remark")
    private String trading_contact_remark;

    @Basic
    @Column(name = "has_purpose_contact")
    private boolean has_purpose_contact;

    @Basic
    @Column(name = "purpose_contact_des")
    private int purpose_contact_des;

    @Basic
    @Column(name = "purpose_contact_page")
    private String purpose_contact_page;

    @Basic
    @Column(name = "purpose_contact_remark")
    private String purpose_contact_remark;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog")
    private List<MortgageCatalogOther> mortgageCatalogOthers = new ArrayList<>();

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

    public int getClient_id_card_des() {
        return client_id_card_des;
    }

    public void setClient_id_card_des(int client_id_card_des) {
        this.client_id_card_des = client_id_card_des;
    }

    public String getClient_id_card_page() {
        return client_id_card_page;
    }

    public void setClient_id_card_page(String client_id_card_page) {
        this.client_id_card_page = client_id_card_page;
    }

    public String getClient_id_card_remark() {
        return client_id_card_remark;
    }

    public void setClient_id_card_remark(String client_id_card_remark) {
        this.client_id_card_remark = client_id_card_remark;
    }

    public boolean isHas_client_account() {
        return has_client_account;
    }

    public void setHas_client_account(boolean has_client_account) {
        this.has_client_account = has_client_account;
    }

    public boolean isClient_account_home() {
        return client_account_home;
    }

    public void setClient_account_home(boolean client_account_home) {
        this.client_account_home = client_account_home;
    }

    public boolean isClient_account_household() {
        return client_account_household;
    }

    public void setClient_account_household(boolean client_account_household) {
        this.client_account_household = client_account_household;
    }

    public boolean isClient_account_myself() {
        return client_account_myself;
    }

    public void setClient_account_myself(boolean client_account_myself) {
        this.client_account_myself = client_account_myself;
    }

    public int getClient_account_des() {
        return client_account_des;
    }

    public void setClient_account_des(int client_account_des) {
        this.client_account_des = client_account_des;
    }

    public String getClient_account_page() {
        return client_account_page;
    }

    public void setClient_account_page(String client_account_page) {
        this.client_account_page = client_account_page;
    }

    public String getClient_account_remark() {
        return client_account_remark;
    }

    public void setClient_account_remark(String client_account_remark) {
        this.client_account_remark = client_account_remark;
    }

    public boolean isHas_client_spouse_id_card() {
        return has_client_spouse_id_card;
    }

    public void setHas_client_spouse_id_card(boolean has_client_spouse_id_card) {
        this.has_client_spouse_id_card = has_client_spouse_id_card;
    }

    public int getClient_spouse_id_card_des() {
        return client_spouse_id_card_des;
    }

    public void setClient_spouse_id_card_des(int client_spouse_id_card_des) {
        this.client_spouse_id_card_des = client_spouse_id_card_des;
    }

    public String getClient_spouse_id_card_page() {
        return client_spouse_id_card_page;
    }

    public void setClient_spouse_id_card_page(String client_spouse_id_card_page) {
        this.client_spouse_id_card_page = client_spouse_id_card_page;
    }

    public String getClient_spouse_id_card_remark() {
        return client_spouse_id_card_remark;
    }

    public void setClient_spouse_id_card_remark(String client_spouse_id_card_remark) {
        this.client_spouse_id_card_remark = client_spouse_id_card_remark;
    }

    public boolean isHas_client_spouse_account() {
        return has_client_spouse_account;
    }

    public void setHas_client_spouse_account(boolean has_client_spouse_account) {
        this.has_client_spouse_account = has_client_spouse_account;
    }

    public boolean isClient_spouse_account_home() {
        return client_spouse_account_home;
    }

    public void setClient_spouse_account_home(boolean client_spouse_account_home) {
        this.client_spouse_account_home = client_spouse_account_home;
    }

    public boolean isClient_spouse_account_household() {
        return client_spouse_account_household;
    }

    public void setClient_spouse_account_household(boolean client_spouse_account_household) {
        this.client_spouse_account_household = client_spouse_account_household;
    }

    public boolean isClient_spouse_account_myself() {
        return client_spouse_account_myself;
    }

    public void setClient_spouse_account_myself(boolean client_spouse_account_myself) {
        this.client_spouse_account_myself = client_spouse_account_myself;
    }

    public int getClient_spouse_account_des() {
        return client_spouse_account_des;
    }

    public void setClient_spouse_account_des(int client_spouse_account_des) {
        this.client_spouse_account_des = client_spouse_account_des;
    }

    public String getClient_spouse_account_page() {
        return client_spouse_account_page;
    }

    public void setClient_spouse_account_page(String client_spouse_account_page) {
        this.client_spouse_account_page = client_spouse_account_page;
    }

    public String getClient_spouse_account_remark() {
        return client_spouse_account_remark;
    }

    public void setClient_spouse_account_remark(String client_spouse_account_remark) {
        this.client_spouse_account_remark = client_spouse_account_remark;
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

    public String getMarriage_proof_des() {
        return marriage_proof_des;
    }

    public void setMarriage_proof_des(String marriage_proof_des) {
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

    public int getHouse_mortgage_des() {
        return house_mortgage_des;
    }

    public void setHouse_mortgage_des(int house_mortgage_des) {
        this.house_mortgage_des = house_mortgage_des;
    }

    public String getHouse_mortgage_page() {
        return house_mortgage_page;
    }

    public void setHouse_mortgage_page(String house_mortgage_page) {
        this.house_mortgage_page = house_mortgage_page;
    }

    public String getHouse_mortgage_remark() {
        return house_mortgage_remark;
    }

    public void setHouse_mortgage_remark(String house_mortgage_remark) {
        this.house_mortgage_remark = house_mortgage_remark;
    }

    public boolean isHas_assets_certificate() {
        return has_assets_certificate;
    }

    public void setHas_assets_certificate(boolean has_assets_certificate) {
        this.has_assets_certificate = has_assets_certificate;
    }

    public boolean isAssets_house_certificate() {
        return assets_house_certificate;
    }

    public void setAssets_house_certificate(boolean assets_house_certificate) {
        this.assets_house_certificate = assets_house_certificate;
    }

    public String getAssets_house_number() {
        return assets_house_number;
    }

    public void setAssets_house_number(String assets_house_number) {
        this.assets_house_number = assets_house_number;
    }

    public boolean isAssets_other() {
        return assets_other;
    }

    public void setAssets_other(boolean assets_other) {
        this.assets_other = assets_other;
    }

    public String getAssets_other_remark() {
        return assets_other_remark;
    }

    public void setAssets_other_remark(String assets_other_remark) {
        this.assets_other_remark = assets_other_remark;
    }

    public boolean isAssets_car_certificate() {
        return assets_car_certificate;
    }

    public void setAssets_car_certificate(boolean assets_car_certificate) {
        this.assets_car_certificate = assets_car_certificate;
    }

    public String getAssets_car_number() {
        return assets_car_number;
    }

    public void setAssets_car_number(String assets_car_number) {
        this.assets_car_number = assets_car_number;
    }

    public int getAssets_certificate_des() {
        return assets_certificate_des;
    }

    public void setAssets_certificate_des(int assets_certificate_des) {
        this.assets_certificate_des = assets_certificate_des;
    }

    public String getAssets_certificate_page() {
        return assets_certificate_page;
    }

    public void setAssets_certificate_page(String assets_certificate_page) {
        this.assets_certificate_page = assets_certificate_page;
    }

    public String getAssets_certificate_remark() {
        return assets_certificate_remark;
    }

    public void setAssets_certificate_remark(String assets_certificate_remark) {
        this.assets_certificate_remark = assets_certificate_remark;
    }

    public boolean isHas_income_proof() {
        return has_income_proof;
    }

    public void setHas_income_proof(boolean has_income_proof) {
        this.has_income_proof = has_income_proof;
    }

    public int getIncome_proof_des() {
        return income_proof_des;
    }

    public void setIncome_proof_des(int income_proof_des) {
        this.income_proof_des = income_proof_des;
    }

    public String getIncome_proof_page() {
        return income_proof_page;
    }

    public void setIncome_proof_page(String income_proof_page) {
        this.income_proof_page = income_proof_page;
    }

    public String getIncome_proof_remark() {
        return income_proof_remark;
    }

    public void setIncome_proof_remark(String income_proof_remark) {
        this.income_proof_remark = income_proof_remark;
    }

    public boolean isHas_business_license() {
        return has_business_license;
    }

    public void setHas_business_license(boolean has_business_license) {
        this.has_business_license = has_business_license;
    }

    public int getBusiness_license_des() {
        return business_license_des;
    }

    public void setBusiness_license_des(int business_license_des) {
        this.business_license_des = business_license_des;
    }

    public String getBusiness_license_page() {
        return business_license_page;
    }

    public void setBusiness_license_page(String business_license_page) {
        this.business_license_page = business_license_page;
    }

    public String getBusiness_license_remark() {
        return business_license_remark;
    }

    public void setBusiness_license_remark(String business_license_remark) {
        this.business_license_remark = business_license_remark;
    }

    public boolean isHas_legal_representative() {
        return has_legal_representative;
    }

    public void setHas_legal_representative(boolean has_legal_representative) {
        this.has_legal_representative = has_legal_representative;
    }

    public int getLegal_representative_des() {
        return legal_representative_des;
    }

    public void setLegal_representative_des(int legal_representative_des) {
        this.legal_representative_des = legal_representative_des;
    }

    public String getLegal_representative_page() {
        return legal_representative_page;
    }

    public void setLegal_representative_page(String legal_representative_page) {
        this.legal_representative_page = legal_representative_page;
    }

    public String getLegal_representative_remark() {
        return legal_representative_remark;
    }

    public void setLegal_representative_remark(String legal_representative_remark) {
        this.legal_representative_remark = legal_representative_remark;
    }

    public boolean isHas_company_statute() {
        return has_company_statute;
    }

    public void setHas_company_statute(boolean has_company_statute) {
        this.has_company_statute = has_company_statute;
    }

    public int getCompany_statute_des() {
        return company_statute_des;
    }

    public void setCompany_statute_des(int company_statute_des) {
        this.company_statute_des = company_statute_des;
    }

    public String getCompany_statute_page() {
        return company_statute_page;
    }

    public void setCompany_statute_page(String company_statute_page) {
        this.company_statute_page = company_statute_page;
    }

    public String getCompany_statute_remark() {
        return company_statute_remark;
    }

    public void setCompany_statute_remark(String company_statute_remark) {
        this.company_statute_remark = company_statute_remark;
    }

    public boolean isHas_grant_deed() {
        return has_grant_deed;
    }

    public void setHas_grant_deed(boolean has_grant_deed) {
        this.has_grant_deed = has_grant_deed;
    }

    public int getGrant_deed_des() {
        return grant_deed_des;
    }

    public void setGrant_deed_des(int grant_deed_des) {
        this.grant_deed_des = grant_deed_des;
    }

    public String getGrant_deed_page() {
        return grant_deed_page;
    }

    public void setGrant_deed_page(String grant_deed_page) {
        this.grant_deed_page = grant_deed_page;
    }

    public String getGrant_deed_remark() {
        return grant_deed_remark;
    }

    public void setGrant_deed_remark(String grant_deed_remark) {
        this.grant_deed_remark = grant_deed_remark;
    }

    public boolean isHas_trading_contact() {
        return has_trading_contact;
    }

    public void setHas_trading_contact(boolean has_trading_contact) {
        this.has_trading_contact = has_trading_contact;
    }

    public int getTrading_contact_des() {
        return trading_contact_des;
    }

    public void setTrading_contact_des(int trading_contact_des) {
        this.trading_contact_des = trading_contact_des;
    }

    public String getTrading_contact_page() {
        return trading_contact_page;
    }

    public void setTrading_contact_page(String trading_contact_page) {
        this.trading_contact_page = trading_contact_page;
    }

    public String getTrading_contact_remark() {
        return trading_contact_remark;
    }

    public void setTrading_contact_remark(String trading_contact_remark) {
        this.trading_contact_remark = trading_contact_remark;
    }

    public boolean isHas_purpose_contact() {
        return has_purpose_contact;
    }

    public void setHas_purpose_contact(boolean has_purpose_contact) {
        this.has_purpose_contact = has_purpose_contact;
    }

    public int getPurpose_contact_des() {
        return purpose_contact_des;
    }

    public void setPurpose_contact_des(int purpose_contact_des) {
        this.purpose_contact_des = purpose_contact_des;
    }

    public String getPurpose_contact_page() {
        return purpose_contact_page;
    }

    public void setPurpose_contact_page(String purpose_contact_page) {
        this.purpose_contact_page = purpose_contact_page;
    }

    public String getPurpose_contact_remark() {
        return purpose_contact_remark;
    }

    public void setPurpose_contact_remark(String purpose_contact_remark) {
        this.purpose_contact_remark = purpose_contact_remark;
    }

    public List<MortgageCatalogOther> getMortgageCatalogOthers() {
        return mortgageCatalogOthers;
    }

    public void setMortgageCatalogOthers(List<MortgageCatalogOther> mortgageCatalogOthers) {
        this.mortgageCatalogOthers = mortgageCatalogOthers;
    }
}
