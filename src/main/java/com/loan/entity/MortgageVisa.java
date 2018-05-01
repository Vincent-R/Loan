package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_mortgage_visa", schema = "loan")
public class MortgageVisa {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "set_time")
    private Date set_time;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "state")
    private int state;

    @Basic
    @Column(name = "uncomplete_reason")
    private String uncomplete_reason;

    @Basic
    @Column(name = "operator")
    private String operator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSet_time() {
        return set_time;
    }

    public void setSet_time(Date set_time) {
        this.set_time = set_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUncomplete_reason() {
        return uncomplete_reason;
    }

    public void setUncomplete_reason(String uncomplete_reason) {
        this.uncomplete_reason = uncomplete_reason;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
