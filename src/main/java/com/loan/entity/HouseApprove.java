package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_house_approve", schema = "loan")
public class HouseApprove {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "approve_state")
    private int approve_state;

    @Basic
    @Column(name = "approve_time")
    private Date approve_time;

    @Basic
    @Column(name = "amount")
    private String amount;

    @Basic
    @Column(name = "period")
    private String period;

    @Basic
    @Column(name = "rate")
    private String rate;

    @ManyToOne
    @JoinColumn(name = "loan_condition")
    private LoanCondition loan_condition;

    @Basic
    @Column(name = "remark")
    private String remark;

    @Basic
    @Column(name = "fail_reason")
    private int fail_reason;

    @Basic
    @Column(name = "fail_reason_other")
    private String fail_reason_other;

    @Basic
    @Column(name = "later_action")
    private int later_action;

    @Basic
    @Column(name = "loan_id")
    private String loan_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getApprove_state() {
        return approve_state;
    }

    public void setApprove_state(int approve_state) {
        this.approve_state = approve_state;
    }

    public Date getApprove_time() {
        return approve_time;
    }

    public void setApprove_time(Date approve_time) {
        this.approve_time = approve_time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public LoanCondition getLoan_condition() {
        return loan_condition;
    }

    public void setLoan_condition(LoanCondition loan_condition) {
        this.loan_condition = loan_condition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getFail_reason() {
        return fail_reason;
    }

    public void setFail_reason(int fail_reason) {
        this.fail_reason = fail_reason;
    }

    public String getFail_reason_other() {
        return fail_reason_other;
    }

    public void setFail_reason_other(String fail_reason_other) {
        this.fail_reason_other = fail_reason_other;
    }

    public int getLater_action() {
        return later_action;
    }

    public void setLater_action(int later_action) {
        this.later_action = later_action;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }
}
