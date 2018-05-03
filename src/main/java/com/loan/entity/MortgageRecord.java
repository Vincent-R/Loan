package com.loan.entity;

import javax.persistence.*;

@Entity
@Table(name = "loan_mortgage_records", schema = "loan")
public class MortgageRecord {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "checklist_id")
    private String checklist_id;

    @Basic
    @Column(name = "catalog_id")
    private String catalog_id;

    @Basic
    @Column(name = "form_id")
    private String form_id;

    @Basic
    @Column(name = "advice_id")
    private String advice_id;

    @Basic
    @Column(name = "visa_id")
    private String visa_id;

    @Basic
    @Column(name = "order_id")
    private String order_id;

    @Basic
    @Column(name = "approve_id")
    private String approve_id;

    @Basic
    @Column(name = "mortgage_id")
    private String mortgage_id;

    @Basic
    @Column(name = "loan_id")
    private String loan_id;

    @Basic
    @Column(name = "process_id")
    private String process_id;

    @Basic
    @Column(name = "record_state")
    private int record_state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChecklist_id() {
        return checklist_id;
    }

    public void setChecklist_id(String checklist_id) {
        this.checklist_id = checklist_id;
    }

    public String getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(String catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public String getAdvice_id() {
        return advice_id;
    }

    public void setAdvice_id(String advice_id) {
        this.advice_id = advice_id;
    }

    public String getVisa_id() {
        return visa_id;
    }

    public void setVisa_id(String visa_id) {
        this.visa_id = visa_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getApprove_id() {
        return approve_id;
    }

    public void setApprove_id(String approve_id) {
        this.approve_id = approve_id;
    }

    public String getMortgage_id() {
        return mortgage_id;
    }

    public void setMortgage_id(String mortgage_id) {
        this.mortgage_id = mortgage_id;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getProcess_id() {
        return process_id;
    }

    public void setProcess_id(String process_id) {
        this.process_id = process_id;
    }

    public int getRecord_state() {
        return record_state;
    }

    public void setRecord_state(int record_state) {
        this.record_state = record_state;
    }
}
