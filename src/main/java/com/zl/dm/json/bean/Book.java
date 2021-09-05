package com.zl.dm.json.bean;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Book {

    private String name;

    private String[] keyWords;

    private String author;

    private BigDecimal price;

    private Map<Date,String> setmants;

    private List<String> kws = new ArrayList<>();

    private Map<Integer,String> maps;

    private char[] chars;

    private Date pubTime;

    private java.sql.Date createAt;

    private Timestamp updateAt;

    private Time startTime;

    private Book book;

    private Status status;


    /*public String getName() {
        return name;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    /*public String getAuthor() {
        return author;
    }*/

    public String getTitle(){
        return "non field value";
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public java.sql.Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(java.sql.Date createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Map<Date, String> getSetmants() {
        return setmants;
    }

    public void setSetmants(Map<Date, String> setmants) {
        this.setmants = setmants;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getKws() {
        return kws;
    }

    public void setKws(List<String> kws) {
        this.kws = kws;
    }

    public Map<Integer, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<Integer, String> maps) {
        this.maps = maps;
    }
}
