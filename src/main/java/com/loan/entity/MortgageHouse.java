package com.loan.entity;

import javax.persistence.*;

@Entity
@Table(name = "loan_mortgage_house")
public class MortgageHouse {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "area")
    private String area;

    @Basic
    @Column(name = "enquiry_result")
    private String enquiry_result;

    @Basic
    @Column(name = "total_price")
    private String total_price;

    @Basic
    @Column(name = "checklist_id")
    private String checklist_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEnquiry_result() {
        return enquiry_result;
    }

    public void setEnquiry_result(String enquiry_result) {
        this.enquiry_result = enquiry_result;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getChecklist_id() {
        return checklist_id;
    }

    public void setChecklist_id(String checklist_id) {
        this.checklist_id = checklist_id;
    }
}
