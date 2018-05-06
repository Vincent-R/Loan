package com.loan.returnObj;

public class MObjApprove {

    private String taskId;

    private String name;

    private String phone;

    private String report_type;

    private String state;

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

    public String getReport_type() {
        return report_type;
    }

    public void setReport_type(String report_type) {
        this.report_type = report_type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public MObjApprove(){}

    public MObjApprove(String taskId, String name, String phone, String type, String state){
        this.taskId = taskId;
        this.name = name;
        this.phone = phone;
        this.report_type = type;
        this.state = state;
    }
}