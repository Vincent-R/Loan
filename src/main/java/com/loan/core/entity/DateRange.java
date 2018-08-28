package com.loan.core.entity;

/**
 * Created by Angel on 2017/6/20.
 */
public class DateRange {
    private String startDate;
    private String endDate;

    public DateRange(String startDate, String endDate) {
        this.startDate =startDate;
        this.endDate = endDate;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
