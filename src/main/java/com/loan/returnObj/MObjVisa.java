package com.loan.returnObj;

public class MObjVisa {
    private String taskId;

    private String name;

    private String phone;

    private String state;

    private int loan_type;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(int loan_type) {
        this.loan_type = loan_type;
    }

    public MObjVisa(){}

    public MObjVisa(String taskId, String name, String phone, String state, int loan_type){
        this.taskId = taskId;
        this.name = name;
        this.phone = phone;
        this.state = state;
        this.loan_type = loan_type;
    }
}
