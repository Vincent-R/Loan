package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_mortgage_record", schema = "loan")
public class MortgageRecord {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "checklist")
    private String checklist;

    @Basic
    @Column(name = "checklist_operator")
    private String checklist_operator;

    @Basic
    @Column(name = "advice")
    private String advice;

    @Basic
    @Column(name = "advice_operator")
    private String advice_operator;

    @Basic
    @Column(name = "catalog")
    private String catalog;

    @Basic
    @Column(name = "form")
    private String form;

    @Basic
    @Column(name = "visa_finish_time")
    private Date visa_finish_time;

    @Basic
    @Column(name = "visa_address")
    private String visa_address;

    @Basic
    @Column(name = "visa_operator")
    private String visa_operator;

    @Basic
    @Column(name = "order_finish_time")
    private Date order_finish_time;

    @Basic
    @Column(name = "order_evaluate_company")
    private String order_evaluate_company;

    @Basic
    @Column(name = "order_report_finish_time")
    private Date order_report_finish_time;

    @Basic
    @Column(name = "approve_data_complete")
    private boolean approve_data_complete;

    @Basic
    @Column(name = "approve_time")
    private Date approve_time;

    @Basic
    @Column(name = "approve_pass")
    private boolean approve_pass;

    @Basic
    @Column(name = "approve_zp_finish_time")
    private Date approve_zp_finish_time;

    @Basic
    @Column(name = "mortgage_finish_time")
    private Date mortgage_finish_time;

    @Basic
    @Column(name = "mortgage_need_guarantee")
    private boolean mortgage_need_guarantee;

    @Basic
    @Column(name = "mortgage_g_stamp")
    private boolean mortgage_g_stamp;

    @Basic
    @Column(name = "mortgage_g_stamp_time")
    private Date mortgage_g_stamp_time;

    @Basic
    @Column(name = "mortgage_g_time")
    private Date mortgage_g_time;

    @Basic
    @Column(name = "charge_skip")
    private boolean charge_skip;

    @Basic
    @Column(name = "charge_finish_time")
    private Date charge_finish_time;

    @Basic
    @Column(name = "process_id")
    private String process_id;

    @Basic
    @Column(name = "record_state")
    private int record_state;

    @Basic
    @Column(name = "abandon_time")
    private Date abandon_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChecklist() {
        return checklist;
    }

    public void setChecklist(String checklist) {
        this.checklist = checklist;
    }

    public void setChecklist_operator(String checklist_operator) {
        this.checklist_operator = checklist_operator;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getAdvice_operator() {
        return advice_operator;
    }

    public void setAdvice_operator(String advice_operator) {
        this.advice_operator = advice_operator;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Date getVisa_finish_time() {
        return visa_finish_time;
    }

    public void setVisa_finish_time(Date visa_finish_time) {
        this.visa_finish_time = visa_finish_time;
    }

    public String getVisa_address() {
        return visa_address;
    }

    public void setVisa_address(String visa_address) {
        this.visa_address = visa_address;
    }

    public String getVisa_operator() {
        return visa_operator;
    }

    public void setVisa_operator(String visa_operator) {
        this.visa_operator = visa_operator;
    }

    public Date getOrder_finish_time() {
        return order_finish_time;
    }

    public void setOrder_finish_time(Date order_finish_time) {
        this.order_finish_time = order_finish_time;
    }

    public String getOrder_evaluate_company() {
        return order_evaluate_company;
    }

    public void setOrder_evaluate_company(String order_evaluate_company) {
        this.order_evaluate_company = order_evaluate_company;
    }

    public Date getOrder_report_finish_time() {
        return order_report_finish_time;
    }

    public void setOrder_report_finish_time(Date order_report_finish_time) {
        this.order_report_finish_time = order_report_finish_time;
    }

    public boolean isApprove_data_complete() {
        return approve_data_complete;
    }

    public void setApprove_data_complete(boolean approve_data_complete) {
        this.approve_data_complete = approve_data_complete;
    }

    public Date getApprove_time() {
        return approve_time;
    }

    public void setApprove_time(Date approve_time) {
        this.approve_time = approve_time;
    }

    public boolean isApprove_pass() {
        return approve_pass;
    }

    public void setApprove_pass(boolean approve_pass) {
        this.approve_pass = approve_pass;
    }

    public Date getApprove_zp_finish_time() {
        return approve_zp_finish_time;
    }

    public void setApprove_zp_finish_time(Date approve_zp_finish_time) {
        this.approve_zp_finish_time = approve_zp_finish_time;
    }

    public Date getMortgage_finish_time() {
        return mortgage_finish_time;
    }

    public void setMortgage_finish_time(Date mortgage_finish_time) {
        this.mortgage_finish_time = mortgage_finish_time;
    }

    public boolean isMortgage_need_guarantee() {
        return mortgage_need_guarantee;
    }

    public void setMortgage_need_guarantee(boolean mortgage_need_guarantee) {
        this.mortgage_need_guarantee = mortgage_need_guarantee;
    }

    public boolean isMortgage_g_stamp() {
        return mortgage_g_stamp;
    }

    public void setMortgage_g_stamp(boolean mortgage_g_stamp) {
        this.mortgage_g_stamp = mortgage_g_stamp;
    }

    public Date getMortgage_g_stamp_time() {
        return mortgage_g_stamp_time;
    }

    public void setMortgage_g_stamp_time(Date mortgage_g_stamp_time) {
        this.mortgage_g_stamp_time = mortgage_g_stamp_time;
    }

    public Date getMortgage_g_time() {
        return mortgage_g_time;
    }

    public void setMortgage_g_time(Date mortgage_g_time) {
        this.mortgage_g_time = mortgage_g_time;
    }

    public boolean isCharge_skip() {
        return charge_skip;
    }

    public void setCharge_skip(boolean charge_skip) {
        this.charge_skip = charge_skip;
    }

    public Date getCharge_finish_time() {
        return charge_finish_time;
    }

    public void setCharge_finish_time(Date charge_finish_time) {
        this.charge_finish_time = charge_finish_time;
    }

    public String getChecklist_operator() {
        return checklist_operator;
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

    public Date getAbandon_time() {
        return abandon_time;
    }

    public void setAbandon_time(Date abandon_time) {
        this.abandon_time = abandon_time;
    }
}
