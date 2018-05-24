package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_house_charge", schema = "loan")
public class HouseCharge {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "charge_a_state")
    private int charge_a_state;

    @Basic
    @Column(name = "charge_a_time")
    private Date charge_a_time;

    @Basic
    @Column(name = "charge_b_state")
    private int charge_b_state;

    @Basic
    @Column(name = "charge_b_time")
    private Date charge_b_time;

    @Basic
    @Column(name = "charge_c_state")
    private int charge_c_state;

    @Basic
    @Column(name = "charge_c_time")
    private Date charge_c_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCharge_a_state() {
        return charge_a_state;
    }

    public void setCharge_a_state(int charge_a_state) {
        this.charge_a_state = charge_a_state;
    }

    public Date getCharge_a_time() {
        return charge_a_time;
    }

    public void setCharge_a_time(Date charge_a_time) {
        this.charge_a_time = charge_a_time;
    }

    public int getCharge_b_state() {
        return charge_b_state;
    }

    public void setCharge_b_state(int charge_b_state) {
        this.charge_b_state = charge_b_state;
    }

    public Date getCharge_b_time() {
        return charge_b_time;
    }

    public void setCharge_b_time(Date charge_b_time) {
        this.charge_b_time = charge_b_time;
    }

    public int getCharge_c_state() {
        return charge_c_state;
    }

    public void setCharge_c_state(int charge_c_state) {
        this.charge_c_state = charge_c_state;
    }

    public Date getCharge_c_time() {
        return charge_c_time;
    }

    public void setCharge_c_time(Date charge_c_time) {
        this.charge_c_time = charge_c_time;
    }
}
