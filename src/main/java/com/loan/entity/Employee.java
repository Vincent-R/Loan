package com.loan.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "loan_employees", schema = "loan")
public class Employee {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "account")
    private String account;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "handle_m_order_receive")
    private boolean handle_m_order_receive;

    @Basic
    @Column(name = "handle_m_view")
    private boolean handle_m_view;

    @Basic
    @Column(name = "handle_m_sign")
    private boolean handle_m_sign;

    @Basic
    @Column(name = "handle_m_ordering")
    private boolean handle_m_ordering;

    @Basic
    @Column(name = "handle_m_approve")
    private boolean handle_m_approve;

    @Basic
    @Column(name = "handle_m_mortgage")
    private boolean handle_m_mortgage;

    @Basic
    @Column(name = "handle_m_loan")
    private boolean handle_m_loan;

    @Basic
    @Column(name = "handle_h_order_receive")
    private boolean handle_h_order_receive;

    @Basic
    @Column(name = "handle_h_view")
    private boolean handle_h_view;

    @Basic
    @Column(name = "handle_h_sign")
    private boolean handle_h_sign;

    @Basic
    @Column(name = "handle_h_ordering")
    private boolean handle_h_ordering;

    @Basic
    @Column(name = "handle_h_approve")
    private boolean handle_h_approve;

    @Basic
    @Column(name = "handle_h_mortgage")
    private boolean handle_h_mortgage;

    @Basic
    @Column(name = "handle_h_loan")
    private boolean handle_h_loan;

    @Basic
    @Column(name = "query_m_status")
    private boolean query_m_status;

    @Basic
    @Column(name = "query_m_order_receive")
    private boolean query_m_order_receive;

    @Basic
    @Column(name = "query_m_view")
    private boolean query_m_view;

    @Basic
    @Column(name = "query_m_sign")
    private boolean query_m_sign;

    @Basic
    @Column(name = "query_m_ordering")
    private boolean query_m_ordering;

    @Basic
    @Column(name = "query_m_approve")
    private boolean query_m_approve;

    @Basic
    @Column(name = "query_m_mortgage")
    private boolean query_m_mortgage;

    @Basic
    @Column(name = "query_m_loan")
    private boolean query_m_loan;

    @Basic
    @Column(name = "query_h_status")
    private boolean query_h_status;

    @Basic
    @Column(name = "query_h_order_receive")
    private boolean query_h_order_receive;

    @Basic
    @Column(name = "query_h_view")
    private boolean query_h_view;

    @Basic
    @Column(name = "query_h_sign")
    private boolean query_h_sign;

    @Basic
    @Column(name = "query_h_ordering")
    private boolean query_h_ordering;

    @Basic
    @Column(name = "query_h_approve")
    private boolean query_h_approve;

    @Basic
    @Column(name = "query_h_mortgage")
    private boolean query_h_mortgage;

    @Basic
    @Column(name = "query_h_loan")
    private boolean query_h_loan;

    @Basic
    @Column(name = "edit_m_order_receive")
    private boolean edit_m_order_receive;

    @Basic
    @Column(name = "edit_m_view")
    private boolean edit_m_view;

    @Basic
    @Column(name = "edit_m_sign")
    private boolean edit_m_sign;

    @Basic
    @Column(name = "edit_m_ordering")
    private boolean edit_m_ordering;

    @Basic
    @Column(name = "edit_m_approve")
    private boolean edit_m_approve;

    @Basic
    @Column(name = "edit_m_mortgage")
    private boolean edit_m_mortgage;

    @Basic
    @Column(name = "edit_m_loan")
    private boolean edit_m_loan;

    @Basic
    @Column(name = "edit_h_order_receive")
    private boolean edit_h_order_receive;

    @Basic
    @Column(name = "edit_h_view")
    private boolean edit_h_view;

    @Basic
    @Column(name = "edit_h_sign")
    private boolean edit_h_sign;

    @Basic
    @Column(name = "edit_h_ordering")
    private boolean edit_h_ordering;

    @Basic
    @Column(name = "edit_h_approve")
    private boolean edit_h_approve;

    @Basic
    @Column(name = "edit_h_mortgage")
    private boolean edit_h_mortgage;

    @Basic
    @Column(name = "edit_h_loan")
    private boolean edit_h_loan;

    @Basic
    @Column(name = "delete_m_loan")
    private boolean delete_m_loan;

    @Basic
    @Column(name = "delete_h_loan")
    private boolean delete_h_loan;

    @Basic
    @Column(name = "manage_department_add")
    private boolean manage_department_add;

    @Basic
    @Column(name = "manage_department_edit")
    private boolean manage_department_edit;

    @Basic
    @Column(name = "manage_department_delete")
    private boolean manage_department_delete;

    @Basic
    @Column(name = "manage_department_query")
    private boolean manage_department_query;

    @Basic
    @Column(name = "manage_account_add")
    private boolean manage_account_add;

    @Basic
    @Column(name = "manage_account_edit")
    private boolean manage_account_edit;

    @Basic
    @Column(name = "manage_account_delete")
    private boolean manage_account_delete;

    @Basic
    @Column(name = "manage_account_query")
    private boolean manage_account_query;

    @Basic
    @Column(name = "manage_authority")
    private boolean manage_authority;

    @Basic
    @Column(name = "manage_notice_add")
    private boolean manage_notice_add;

    @Basic
    @Column(name = "manage_notice_edit")
    private boolean manage_notice_edit;

    @Basic
    @Column(name = "manage_notice_delete")
    private boolean manage_notice_delete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isHandle_m_order_receive() {
        return handle_m_order_receive;
    }

    public void setHandle_m_order_receive(boolean handle_m_order_receive) {
        this.handle_m_order_receive = handle_m_order_receive;
    }

    public boolean isHandle_m_view() {
        return handle_m_view;
    }

    public void setHandle_m_view(boolean handle_m_view) {
        this.handle_m_view = handle_m_view;
    }

    public boolean isHandle_m_sign() {
        return handle_m_sign;
    }

    public void setHandle_m_sign(boolean handle_m_sign) {
        this.handle_m_sign = handle_m_sign;
    }

    public boolean isHandle_m_ordering() {
        return handle_m_ordering;
    }

    public void setHandle_m_ordering(boolean handle_m_ordering) {
        this.handle_m_ordering = handle_m_ordering;
    }

    public boolean isHandle_m_approve() {
        return handle_m_approve;
    }

    public void setHandle_m_approve(boolean handle_m_approve) {
        this.handle_m_approve = handle_m_approve;
    }

    public boolean isHandle_m_mortgage() {
        return handle_m_mortgage;
    }

    public void setHandle_m_mortgage(boolean handle_m_mortgage) {
        this.handle_m_mortgage = handle_m_mortgage;
    }

    public boolean isHandle_m_loan() {
        return handle_m_loan;
    }

    public void setHandle_m_loan(boolean handle_m_loan) {
        this.handle_m_loan = handle_m_loan;
    }

    public boolean isHandle_h_order_receive() {
        return handle_h_order_receive;
    }

    public void setHandle_h_order_receive(boolean handle_h_order_receive) {
        this.handle_h_order_receive = handle_h_order_receive;
    }

    public boolean isHandle_h_view() {
        return handle_h_view;
    }

    public void setHandle_h_view(boolean handle_h_view) {
        this.handle_h_view = handle_h_view;
    }

    public boolean isHandle_h_sign() {
        return handle_h_sign;
    }

    public void setHandle_h_sign(boolean handle_h_sign) {
        this.handle_h_sign = handle_h_sign;
    }

    public boolean isHandle_h_ordering() {
        return handle_h_ordering;
    }

    public void setHandle_h_ordering(boolean handle_h_ordering) {
        this.handle_h_ordering = handle_h_ordering;
    }

    public boolean isHandle_h_approve() {
        return handle_h_approve;
    }

    public void setHandle_h_approve(boolean handle_h_approve) {
        this.handle_h_approve = handle_h_approve;
    }

    public boolean isHandle_h_mortgage() {
        return handle_h_mortgage;
    }

    public void setHandle_h_mortgage(boolean handle_h_mortgage) {
        this.handle_h_mortgage = handle_h_mortgage;
    }

    public boolean isHandle_h_loan() {
        return handle_h_loan;
    }

    public void setHandle_h_loan(boolean handle_h_loan) {
        this.handle_h_loan = handle_h_loan;
    }

    public boolean isQuery_m_status() {
        return query_m_status;
    }

    public void setQuery_m_status(boolean query_m_status) {
        this.query_m_status = query_m_status;
    }

    public boolean isQuery_m_order_receive() {
        return query_m_order_receive;
    }

    public void setQuery_m_order_receive(boolean query_m_order_receive) {
        this.query_m_order_receive = query_m_order_receive;
    }

    public boolean isQuery_m_view() {
        return query_m_view;
    }

    public void setQuery_m_view(boolean query_m_view) {
        this.query_m_view = query_m_view;
    }

    public boolean isQuery_m_sign() {
        return query_m_sign;
    }

    public void setQuery_m_sign(boolean query_m_sign) {
        this.query_m_sign = query_m_sign;
    }

    public boolean isQuery_m_ordering() {
        return query_m_ordering;
    }

    public void setQuery_m_ordering(boolean query_m_ordering) {
        this.query_m_ordering = query_m_ordering;
    }

    public boolean isQuery_m_approve() {
        return query_m_approve;
    }

    public void setQuery_m_approve(boolean query_m_approve) {
        this.query_m_approve = query_m_approve;
    }

    public boolean isQuery_m_mortgage() {
        return query_m_mortgage;
    }

    public void setQuery_m_mortgage(boolean query_m_mortgage) {
        this.query_m_mortgage = query_m_mortgage;
    }

    public boolean isQuery_m_loan() {
        return query_m_loan;
    }

    public void setQuery_m_loan(boolean query_m_loan) {
        this.query_m_loan = query_m_loan;
    }

    public boolean isQuery_h_status() {
        return query_h_status;
    }

    public void setQuery_h_status(boolean query_h_status) {
        this.query_h_status = query_h_status;
    }

    public boolean isQuery_h_order_receive() {
        return query_h_order_receive;
    }

    public void setQuery_h_order_receive(boolean query_h_order_receive) {
        this.query_h_order_receive = query_h_order_receive;
    }

    public boolean isQuery_h_view() {
        return query_h_view;
    }

    public void setQuery_h_view(boolean query_h_view) {
        this.query_h_view = query_h_view;
    }

    public boolean isQuery_h_sign() {
        return query_h_sign;
    }

    public void setQuery_h_sign(boolean query_h_sign) {
        this.query_h_sign = query_h_sign;
    }

    public boolean isQuery_h_ordering() {
        return query_h_ordering;
    }

    public void setQuery_h_ordering(boolean query_h_ordering) {
        this.query_h_ordering = query_h_ordering;
    }

    public boolean isQuery_h_approve() {
        return query_h_approve;
    }

    public void setQuery_h_approve(boolean query_h_approve) {
        this.query_h_approve = query_h_approve;
    }

    public boolean isQuery_h_mortgage() {
        return query_h_mortgage;
    }

    public void setQuery_h_mortgage(boolean query_h_mortgage) {
        this.query_h_mortgage = query_h_mortgage;
    }

    public boolean isQuery_h_loan() {
        return query_h_loan;
    }

    public void setQuery_h_loan(boolean query_h_loan) {
        this.query_h_loan = query_h_loan;
    }

    public boolean isEdit_m_order_receive() {
        return edit_m_order_receive;
    }

    public void setEdit_m_order_receive(boolean edit_m_order_receive) {
        this.edit_m_order_receive = edit_m_order_receive;
    }

    public boolean isEdit_m_view() {
        return edit_m_view;
    }

    public void setEdit_m_view(boolean edit_m_view) {
        this.edit_m_view = edit_m_view;
    }

    public boolean isEdit_m_sign() {
        return edit_m_sign;
    }

    public void setEdit_m_sign(boolean edit_m_sign) {
        this.edit_m_sign = edit_m_sign;
    }

    public boolean isEdit_m_ordering() {
        return edit_m_ordering;
    }

    public void setEdit_m_ordering(boolean edit_m_ordering) {
        this.edit_m_ordering = edit_m_ordering;
    }

    public boolean isEdit_m_approve() {
        return edit_m_approve;
    }

    public void setEdit_m_approve(boolean edit_m_approve) {
        this.edit_m_approve = edit_m_approve;
    }

    public boolean isEdit_m_mortgage() {
        return edit_m_mortgage;
    }

    public void setEdit_m_mortgage(boolean edit_m_mortgage) {
        this.edit_m_mortgage = edit_m_mortgage;
    }

    public boolean isEdit_m_loan() {
        return edit_m_loan;
    }

    public void setEdit_m_loan(boolean edit_m_loan) {
        this.edit_m_loan = edit_m_loan;
    }

    public boolean isEdit_h_order_receive() {
        return edit_h_order_receive;
    }

    public void setEdit_h_order_receive(boolean edit_h_order_receive) {
        this.edit_h_order_receive = edit_h_order_receive;
    }

    public boolean isEdit_h_view() {
        return edit_h_view;
    }

    public void setEdit_h_view(boolean edit_h_view) {
        this.edit_h_view = edit_h_view;
    }

    public boolean isEdit_h_sign() {
        return edit_h_sign;
    }

    public void setEdit_h_sign(boolean edit_h_sign) {
        this.edit_h_sign = edit_h_sign;
    }

    public boolean isEdit_h_ordering() {
        return edit_h_ordering;
    }

    public void setEdit_h_ordering(boolean edit_h_ordering) {
        this.edit_h_ordering = edit_h_ordering;
    }

    public boolean isEdit_h_approve() {
        return edit_h_approve;
    }

    public void setEdit_h_approve(boolean edit_h_approve) {
        this.edit_h_approve = edit_h_approve;
    }

    public boolean isEdit_h_mortgage() {
        return edit_h_mortgage;
    }

    public void setEdit_h_mortgage(boolean edit_h_mortgage) {
        this.edit_h_mortgage = edit_h_mortgage;
    }

    public boolean isEdit_h_loan() {
        return edit_h_loan;
    }

    public void setEdit_h_loan(boolean edit_h_loan) {
        this.edit_h_loan = edit_h_loan;
    }

    public boolean isDelete_h_loan() {
        return delete_h_loan;
    }

    public void setDelete_h_loan(boolean delete_h_loan) {
        this.delete_h_loan = delete_h_loan;
    }

    public boolean isDelete_m_loan() {
        return delete_m_loan;
    }

    public void setDelete_m_loan(boolean delete_m_loan) {
        this.delete_m_loan = delete_m_loan;
    }

    public boolean isManage_department_add() {
        return manage_department_add;
    }

    public void setManage_department_add(boolean manage_department_add) {
        this.manage_department_add = manage_department_add;
    }

    public boolean isManage_department_edit() {
        return manage_department_edit;
    }

    public void setManage_department_edit(boolean manage_department_edit) {
        this.manage_department_edit = manage_department_edit;
    }

    public boolean isManage_department_delete() {
        return manage_department_delete;
    }

    public void setManage_department_delete(boolean manage_department_delete) {
        this.manage_department_delete = manage_department_delete;
    }

    public boolean isManage_department_query() {
        return manage_department_query;
    }

    public void setManage_department_query(boolean manage_department_query) {
        this.manage_department_query = manage_department_query;
    }

    public boolean isManage_account_add() {
        return manage_account_add;
    }

    public void setManage_account_add(boolean manage_account_add) {
        this.manage_account_add = manage_account_add;
    }

    public boolean isManage_account_edit() {
        return manage_account_edit;
    }

    public void setManage_account_edit(boolean manage_account_edit) {
        this.manage_account_edit = manage_account_edit;
    }

    public boolean isManage_account_delete() {
        return manage_account_delete;
    }

    public void setManage_account_delete(boolean manage_account_delete) {
        this.manage_account_delete = manage_account_delete;
    }

    public boolean isManage_account_query() {
        return manage_account_query;
    }

    public void setManage_account_query(boolean manage_account_query) {
        this.manage_account_query = manage_account_query;
    }

    public boolean isManage_authority() {
        return manage_authority;
    }

    public void setManage_authority(boolean manage_authority) {
        this.manage_authority = manage_authority;
    }

    public boolean isManage_notice_add() {
        return manage_notice_add;
    }

    public void setManage_notice_add(boolean manage_notice_add) {
        this.manage_notice_add = manage_notice_add;
    }

    public boolean isManage_notice_edit() {
        return manage_notice_edit;
    }

    public void setManage_notice_edit(boolean manage_notice_edit) {
        this.manage_notice_edit = manage_notice_edit;
    }

    public boolean isManage_notice_delete() {
        return manage_notice_delete;
    }

    public void setManage_notice_delete(boolean manage_notice_delete) {
        this.manage_notice_delete = manage_notice_delete;
    }

    public Employee(){}

    public Employee(String id){
        this.id = id;
        this.account = "";
        this.password = "";
        this.name = "";
        this.department = null;
        this.phone = "";
        this.handle_m_order_receive = false;
        this.handle_m_view = false;
        this.handle_m_sign = false;
        this.handle_m_ordering = false;
        this.handle_m_approve = false;
        this.handle_m_mortgage = false;
        this.handle_m_loan = false;
        this.handle_h_order_receive = false;
        this.handle_h_view = false;
        this.handle_h_sign = false;
        this.handle_h_ordering = false;
        this.handle_h_approve = false;
        this.handle_h_mortgage = false;
        this.handle_h_loan = false;
        this.query_m_status = false;
        this.query_m_order_receive = false;
        this.query_m_view = false;
        this.query_m_sign = false;
        this.query_m_ordering = false;
        this.query_m_approve = false;
        this.query_m_mortgage = false;
        this.query_m_loan = false;
        this.query_h_status = false;
        this.query_h_order_receive = false;
        this.query_h_view = false;
        this.query_h_sign = false;
        this.query_h_ordering = false;
        this.query_h_approve = false;
        this.query_h_mortgage = false;
        this.query_h_loan = false;
        this.edit_m_order_receive = false;
        this.edit_m_view = false;
        this.edit_m_sign = false;
        this.edit_m_ordering = false;
        this.edit_m_approve = false;
        this.edit_m_mortgage = false;
        this.edit_m_loan = false;
        this.edit_h_order_receive = false;
        this.edit_h_view = false;
        this.edit_h_sign = false;
        this.edit_h_ordering = false;
        this.edit_h_approve = false;
        this.edit_h_mortgage = false;
        this.edit_h_loan = false;
        this.delete_m_loan = false;
        this.delete_h_loan = false;
        this.manage_department_add = false;
        this.manage_department_edit = false;
        this.manage_department_delete = false;
        this.manage_department_query = false;
        this.manage_account_add = false;
        this.manage_account_edit = false;
        this.manage_account_delete = false;
        this.manage_account_query = false;
        this.manage_authority = false;
        this.manage_notice_add = false;
        this.manage_notice_edit = false;
        this.manage_notice_delete = false;
    }
}