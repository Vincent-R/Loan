package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_house_report", schema = "loan")
public class HouseReport {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "finish_time")
    private Date finish_time;

    @Basic
    @Column(name = "obligee")
    private String obligee;

    @Basic
    @Column(name = "borrower")
    private String borrower;

    @Basic
    @Column(name = "repose")
    private String repose;

    @Basic
    @Column(name = "house_age")
    private String house_age;

    @Basic
    @Column(name = "house_area")
    private String house_area;

    @Basic
    @Column(name = "house_single")
    private String house_single;

    @Basic
    @Column(name = "house_total")
    private String house_total;

    @Basic
    @Column(name = "loan_amount")
    private String loan_amount;

    @Basic
    @Column(name = "loan_year")
    private String loan_year;

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

    public String getObligee() {
        return obligee;
    }

    public void setObligee(String obligee) {
        this.obligee = obligee;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getRepose() {
        return repose;
    }

    public void setRepose(String repose) {
        this.repose = repose;
    }

    public String getHouse_age() {
        return house_age;
    }

    public void setHouse_age(String house_age) {
        this.house_age = house_age;
    }

    public String getHouse_area() {
        return house_area;
    }

    public void setHouse_area(String house_area) {
        this.house_area = house_area;
    }

    public String getHouse_single() {
        return house_single;
    }

    public void setHouse_single(String house_single) {
        this.house_single = house_single;
    }

    public String getHouse_total() {
        return house_total;
    }

    public void setHouse_total(String house_total) {
        this.house_total = house_total;
    }

    public String getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(String loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getLoan_year() {
        return loan_year;
    }

    public void setLoan_year(String loan_year) {
        this.loan_year = loan_year;
    }
}
