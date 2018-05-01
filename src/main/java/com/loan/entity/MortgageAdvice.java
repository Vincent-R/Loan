package com.loan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_mortgage_advice", schema = "loan")
public class MortgageAdvice {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "finish_time")
    private Date finish_time;

    @Basic
    @Column(name = "proposed_institution")
    private String proposed_institution;

    @Basic
    @Column(name = "proposed_clerk")
    private String proposed_clerk;

    @Basic
    @Column(name = "proposed_amount")
    private String proposed_amount;

    @Basic
    @Column(name = "proposed_period")
    private String proposed_period;

    @Basic
    @Column(name = "rate")
    private String rate;

    @Basic
    @Column(name = "repayment_type")
    private String repayment_type;

    @Basic
    @Column(name = "client_purpose_type")
    private String client_purpose_type;

    @Basic
    @Column(name = "client_purpose")
    private String client_purpose;

    @Basic
    @Column(name = "survey_opinion")
    private String survey_opinion;

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

    public String getProposed_institution() {
        return proposed_institution;
    }

    public void setProposed_institution(String proposed_institution) {
        this.proposed_institution = proposed_institution;
    }

    public String getProposed_clerk() {
        return proposed_clerk;
    }

    public void setProposed_clerk(String proposed_clerk) {
        this.proposed_clerk = proposed_clerk;
    }

    public String getProposed_amount() {
        return proposed_amount;
    }

    public void setProposed_amount(String proposed_amount) {
        this.proposed_amount = proposed_amount;
    }

    public String getProposed_period() {
        return proposed_period;
    }

    public void setProposed_period(String proposed_period) {
        this.proposed_period = proposed_period;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRepayment_type() {
        return repayment_type;
    }

    public void setRepayment_type(String repayment_type) {
        this.repayment_type = repayment_type;
    }

    public String getClient_purpose_type() {
        return client_purpose_type;
    }

    public void setClient_purpose_type(String client_purpose_type) {
        this.client_purpose_type = client_purpose_type;
    }

    public String getClient_purpose() {
        return client_purpose;
    }

    public void setClient_purpose(String client_purpose) {
        this.client_purpose = client_purpose;
    }

    public String getSurvey_opinion() {
        return survey_opinion;
    }

    public void setSurvey_opinion(String survey_opinion) {
        this.survey_opinion = survey_opinion;
    }
}
