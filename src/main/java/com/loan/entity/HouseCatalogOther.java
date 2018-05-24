package com.loan.entity;

import javax.persistence.*;

@Entity
@Table(name = "loan_house_catalog_other", schema = "loan")
public class HouseCatalogOther {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "page")
    private String page;

    @Basic
    @Column(name = "remark")
    private String remark;

    @Basic
    @Column(name = "catalog")
    private String catalog;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
