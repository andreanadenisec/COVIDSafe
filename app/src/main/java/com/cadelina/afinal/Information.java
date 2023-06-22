package com.cadelina.afinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class Information
{
    private String detail;
    private LocalDate date;
    private LocalTime time;

    public Information(String detail, LocalDate date, LocalTime time) {
        this.detail = detail;
        this.date = date;
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
