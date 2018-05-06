package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_mortgage_approve", schema = "loan")
public class MortgageApprove {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "has_data_complete")
    private boolean has_data_complete;

    @Basic
    @Column(name = "sub_branch_state")
    private int sub_branch_state;

    @Basic
    @Column(name = "approval_time")
    private Date approval_time;

    @Basic
    @Column(name = "amount")
    private String amount;

    @Basic
    @Column(name = "year")
    private String year;

    @Basic
    @Column(name = "rate")
    private String rate;

    @Basic
    @Column(name = "note")
    private String note;

    @Basic
    @Column(name = "branch_state")
    private int branch_state;

    @Basic
    @Column(name = "reason")
    private String reason;

    @Basic
    @Column(name = "report_state")
    private int report_state;

    @OneToOne
    @JoinColumn(name = "report_id")
    private MortgageReport report;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHas_data_complete() {
        return has_data_complete;
    }

    public void setHas_data_complete(boolean has_data_complete) {
        this.has_data_complete = has_data_complete;
    }

    public int getSub_branch_state() {
        return sub_branch_state;
    }

    public void setSub_branch_state(int sub_branch_state) {
        this.sub_branch_state = sub_branch_state;
    }

    public Date getApproval_time() {
        return approval_time;
    }

    public void setApproval_time(Date approval_time) {
        this.approval_time = approval_time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getBranch_state() {
        return branch_state;
    }

    public void setBranch_state(int branch_state) {
        this.branch_state = branch_state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getReport_state() {
        return report_state;
    }

    public void setReport_state(int report_state) {
        this.report_state = report_state;
    }

    public MortgageReport getReport() {
        return report;
    }

    public void setReport(MortgageReport report) {
        this.report = report;
    }
}
