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

    @Basic
    @Column(name = "report_time")
    private Date report_time;

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

    public Date getReport_time() {
        return report_time;
    }

    public void setReport_time(Date report_time) {
        this.report_time = report_time;
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
