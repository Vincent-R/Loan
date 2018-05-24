package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_house_record", schema = "loan")
public class HouseRecord {
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
    @Column(name = "visa_catalog")
    private String visa_catalog;

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
    @Column(name = "order_report_type")
    private int order_report_type;

    @Basic
    @Column(name = "order_report")
    private String order_report;

    @Basic
    @Column(name = "order_operator")
    private String order_operator;

    @Basic
    @Column(name = "zjsj_house_check_time")
    private Date zjsj_house_check_time;

    @Basic
    @Column(name = "zjsj_credit_investigate_time")
    private Date zjsj_credit_investigate_time;

    @Basic
    @Column(name = "zjsj_zj_finish_time")
    private Date zjsj_zj_finish_time;

    @Basic
    @Column(name = "zjsj_sj_finish_time")
    private Date zjsj_sj_finish_time;

    @Basic
    @Column(name = "approve_time")
    private Date approve_time;

    @Basic
    @Column(name = "approve_pass")
    private boolean approve_pass;

    @Basic
    @Column(name = "transfer_finish_time")
    private Date transfer_finish_time;

    @Basic
    @Column(name = "transfer_acknowledge_time")
    private Date transfer_acknowledge_time;

    @Basic
    @Column(name = "transfer_operator")
    private String transfer_operator;

    @Basic
    @Column(name = "mortgage_comfirm_time")
    private Date mortgage_comfirm_time;

    @Basic
    @Column(name = "mortgage_obtain_evidence_time")
    private Date mortgage_obtain_evidence_time;

    @Basic
    @Column(name = "mortgage_counter_evidence_time")
    private Date mortgage_counter_evidence_time;

    @Basic
    @Column(name = "guarantee_stamp")
    private boolean guarantee_stamp;

    @Basic
    @Column(name = "guarantee_stamp_time")
    private Date guarantee_stamp_time;

    @Basic
    @Column(name = "guarantee_time")
    private Date guarantee_time;

    @Basic
    @Column(name = "guarantee_zp")
    private String guarantee_zp;

    @Basic
    @Column(name = "guarantee_operator")
    private String guarantee_operator;

    @Basic
    @Column(name = "charge_skip")
    private boolean charge_skip;

    @Basic
    @Column(name = "charge")
    private String charge;

    @Basic
    @Column(name = "process_id")
    private String process_id;

    @Basic
    @Column(name = "record_state")
    private int record_state;

    @Basic
    @Column(name = "abandon_time")
    private Date abandon_time;

    @Basic
    @Column(name = "abandon_operator")
    private String abandon_operator;

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

    public String getChecklist_operator() {
        return checklist_operator;
    }

    public void setChecklist_operator(String checklist_operator) {
        this.checklist_operator = checklist_operator;
    }

    public String getVisa_catalog() {
        return visa_catalog;
    }

    public void setVisa_catalog(String visa_catalog) {
        this.visa_catalog = visa_catalog;
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

    public int getOrder_report_type() {
        return order_report_type;
    }

    public void setOrder_report_type(int order_report_type) {
        this.order_report_type = order_report_type;
    }

    public String getOrder_report() {
        return order_report;
    }

    public void setOrder_report(String order_report) {
        this.order_report = order_report;
    }

    public String getOrder_operator() {
        return order_operator;
    }

    public void setOrder_operator(String order_operator) {
        this.order_operator = order_operator;
    }

    public Date getZjsj_house_check_time() {
        return zjsj_house_check_time;
    }

    public void setZjsj_house_check_time(Date zjsj_house_check_time) {
        this.zjsj_house_check_time = zjsj_house_check_time;
    }

    public Date getZjsj_credit_investigate_time() {
        return zjsj_credit_investigate_time;
    }

    public void setZjsj_credit_investigate_time(Date zjsj_credit_investigate_time) {
        this.zjsj_credit_investigate_time = zjsj_credit_investigate_time;
    }

    public Date getZjsj_zj_finish_time() {
        return zjsj_zj_finish_time;
    }

    public void setZjsj_zj_finish_time(Date zjsj_zj_finish_time) {
        this.zjsj_zj_finish_time = zjsj_zj_finish_time;
    }

    public Date getZjsj_sj_finish_time() {
        return zjsj_sj_finish_time;
    }

    public void setZjsj_sj_finish_time(Date zjsj_sj_finish_time) {
        this.zjsj_sj_finish_time = zjsj_sj_finish_time;
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

    public Date getTransfer_finish_time() {
        return transfer_finish_time;
    }

    public void setTransfer_finish_time(Date transfer_finish_time) {
        this.transfer_finish_time = transfer_finish_time;
    }

    public Date getTransfer_acknowledge_time() {
        return transfer_acknowledge_time;
    }

    public void setTransfer_acknowledge_time(Date transfer_acknowledge_time) {
        this.transfer_acknowledge_time = transfer_acknowledge_time;
    }

    public String getTransfer_operator() {
        return transfer_operator;
    }

    public void setTransfer_operator(String transfer_operator) {
        this.transfer_operator = transfer_operator;
    }

    public Date getMortgage_comfirm_time() {
        return mortgage_comfirm_time;
    }

    public void setMortgage_comfirm_time(Date mortgage_comfirm_time) {
        this.mortgage_comfirm_time = mortgage_comfirm_time;
    }

    public Date getMortgage_obtain_evidence_time() {
        return mortgage_obtain_evidence_time;
    }

    public void setMortgage_obtain_evidence_time(Date mortgage_obtain_evidence_time) {
        this.mortgage_obtain_evidence_time = mortgage_obtain_evidence_time;
    }

    public Date getMortgage_counter_evidence_time() {
        return mortgage_counter_evidence_time;
    }

    public void setMortgage_counter_evidence_time(Date mortgage_counter_evidence_time) {
        this.mortgage_counter_evidence_time = mortgage_counter_evidence_time;
    }

    public boolean isGuarantee_stamp() {
        return guarantee_stamp;
    }

    public void setGuarantee_stamp(boolean guarantee_stamp) {
        this.guarantee_stamp = guarantee_stamp;
    }

    public Date getGuarantee_stamp_time() {
        return guarantee_stamp_time;
    }

    public void setGuarantee_stamp_time(Date guarantee_stamp_time) {
        this.guarantee_stamp_time = guarantee_stamp_time;
    }

    public Date getGuarantee_time() {
        return guarantee_time;
    }

    public void setGuarantee_time(Date guarantee_time) {
        this.guarantee_time = guarantee_time;
    }

    public String getGuarantee_zp() {
        return guarantee_zp;
    }

    public void setGuarantee_zp(String guarantee_zp) {
        this.guarantee_zp = guarantee_zp;
    }

    public String getGuarantee_operator() {
        return guarantee_operator;
    }

    public void setGuarantee_operator(String guarantee_operator) {
        this.guarantee_operator = guarantee_operator;
    }

    public boolean isCharge_skip() {
        return charge_skip;
    }

    public void setCharge_skip(boolean charge_skip) {
        this.charge_skip = charge_skip;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
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

    public String getAbandon_operator() {
        return abandon_operator;
    }

    public void setAbandon_operator(String abandon_operator) {
        this.abandon_operator = abandon_operator;
    }
}
