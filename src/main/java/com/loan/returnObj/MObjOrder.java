package com.loan.returnObj;

import java.util.Date;

public class MObjOrder {

    private String taskId;

    private String name;

    private String phone;

    private String clerk;

    private Date visa_finish_time;

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

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public Date getVisa_finish_time() {
        return visa_finish_time;
    }

    public void setVisa_finish_time(Date visa_finish_time) {
        this.visa_finish_time = visa_finish_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public MObjOrder(){}

    public MObjOrder(String taskId, String name, String phone, String clerk, Date time, String state){
        this.taskId = taskId;
        this.name = name;
        this.phone = phone;
        this.clerk = clerk;
        this.visa_finish_time = time;
        this.state = state;
    }
}
