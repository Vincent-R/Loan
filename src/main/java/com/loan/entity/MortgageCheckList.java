package com.loan.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "loan_mortgage_checklist", schema = "loan")
public class MortgageCheckList {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "finish_time")
    private Date finish_time;//客户交接表完成时间

    @Basic
    @Column(name = "client_name")
    private String client_name;//客户姓名

    @Basic
    @Column(name = "client_phone")
    private String client_phone;//客户联系方式

    @Basic
    @Column(name = "client_id_type")
    private String client_id_type;//证件类型

    @Basic
    @Column(name = "client_id_number")
    private String client_id_number;//证件号码

    @Basic
    @Column(name = "client_work_type")
    private int client_work_type;//客户工作类型

    @Basic
    @Column(name = "client_work_unit")
    private String client_work_unit;//客户工作单位

    @Basic
    @Column(name = "loan_type")
    private int loan_type;//客户贷款种类

    @Basic
    @Column(name = "loan_amount")
    private String loan_amount;//贷款总额

    @Basic
    @Column(name = "loan_period")
    private String loan_period;//贷款期限

    @Basic
    @Column(name = "checklist_source")
    private int checklist_source;//单子来源渠道

    @Basic
    @Column(name = "agent_name")
    private String agent_name;//中介名称

    @Basic
    @Column(name = "remark")
    private String remark;//其他备注事项

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "checklist_id")
    private List<MortgageHouse> mortgageHouses = new ArrayList<>();

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

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getClient_id_type() {
        return client_id_type;
    }

    public void setClient_id_type(String client_id_type) {
        this.client_id_type = client_id_type;
    }

    public String getClient_id_number() {
        return client_id_number;
    }

    public void setClient_id_number(String client_id_number) {
        this.client_id_number = client_id_number;
    }

    public int getClient_work_type() {
        return client_work_type;
    }

    public void setClient_work_type(int client_work_type) {
        this.client_work_type = client_work_type;
    }

    public String getClient_work_unit() {
        return client_work_unit;
    }

    public void setClient_work_unit(String client_work_unit) {
        this.client_work_unit = client_work_unit;
    }

    public int getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(int loan_type) {
        this.loan_type = loan_type;
    }

    public String getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(String loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getLoan_period() {
        return loan_period;
    }

    public void setLoan_period(String loan_period) {
        this.loan_period = loan_period;
    }

    public int getChecklist_source() {
        return checklist_source;
    }

    public void setChecklist_source(int checklist_source) {
        this.checklist_source = checklist_source;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setMortgageHouses(List<MortgageHouse> mortgageHouses) {
        this.mortgageHouses = mortgageHouses;
    }

    public List<MortgageHouse> getMortgageHouses() {
        return mortgageHouses;
    }
}
