package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_mortgage_report", schema = "loan")
public class MortgageReport {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "report_type")
    private int report_type;

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

    @Basic
    @Column(name = "loan_id")
    private String loan_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getReport_type() {
        return report_type;
    }

    public void setReport_type(int report_type) {
        this.report_type = report_type;
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

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }
}
