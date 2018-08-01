package com.loan.returnObj;

import org.intellij.lang.annotations.Identifier;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

public class MObjCommon {

    private String taskId;


    private String name;


    private String phone;


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

    public MObjCommon(){}

    public MObjCommon(String taskId, String name, String phone){
        this.taskId = taskId;
        this.name = name;
        this.phone = phone;
    }
}
