package com.cadelina.afinal;

import java.util.ArrayList;
import java.util.Date;

public class HistoryDetail {

    public static ArrayList<HistoryDetail> historyArrayList = new ArrayList<>();
    public static String NOTE_EDIT_EXTRA = "detailEdit";

    private int id;
    private String titleDate;
    private String detailDate;
    private String detailTime;
    private Date deleted;

    private Boolean firstLoad;

    public Boolean getFirstLoad() {
        return firstLoad;
    }

    public void setFirstLoad(Boolean fl) {
        firstLoad = fl;
    }

    public HistoryDetail(int id, String titleDate, String detailDate, String detailTime, Date deleted) {
        this.id = id;
        this.titleDate = titleDate;
        this.detailDate = detailDate;
        this.detailTime = detailTime;
        this.deleted = deleted;
    }

    public HistoryDetail(int id, String titleDate, String detailDate, String detailTime) {
        this.id = id;
        this.titleDate = titleDate;
        this.detailDate = detailDate;
        this.detailTime = detailTime;
        deleted = null;
    }

    public static HistoryDetail getDetailForID(int passedDetailID) {
        for (HistoryDetail detail : historyArrayList) {
            if(detail.getId() == passedDetailID)
                return detail;
        }
        return null;
    }

    public static ArrayList<HistoryDetail> nonDeletedDetail() {
        ArrayList<HistoryDetail> nonDeleted = new ArrayList<>();
        for (HistoryDetail detail : historyArrayList) {
            if(detail.getDeleted() == null ) {
                nonDeleted.add(detail);
            }
        }
        return nonDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleDate() {
        return titleDate;
    }

    public void setTitleDate(String titleDate) {
        this.titleDate = titleDate;
    }

    public String getDetailDate() {
        return detailDate;
    }

    public void setDetailDate(String detailDate) {
        this.detailDate = detailDate;
    }

    public String getDetailTime() {
        return detailTime;
    }

    public void setDetailTime(String detailTime) {
        this.detailTime = detailTime;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
