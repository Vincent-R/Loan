package com.loan.entity;

import javax.persistence.*;

@Entity
@Table(name = "loan_mortgage_loan_condition", schema = "loan")
public class MortgageLoanCondition {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "need_guarantee")
    private boolean need_guarantee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isNeed_guarantee() {
        return need_guarantee;
    }

    public void setNeed_guarantee(boolean need_guarantee) {
        this.need_guarantee = need_guarantee;
    }
}
