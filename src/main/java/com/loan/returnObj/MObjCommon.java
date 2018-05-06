package com.loan.returnObj;

public class MObjCommon {

    private String taskId;

    private String name;

    private String phone;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public MObjCommon(){}

    public MObjCommon(String taskId, String name, String phone, String state){
        this.taskId = taskId;
        this.name = name;
        this.phone = phone;
        this.state = state;
    }
}
