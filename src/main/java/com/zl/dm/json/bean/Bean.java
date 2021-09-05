package com.zl.dm.json.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

public class Bean {

    private int id;
    private String beanName;
    private String sign;
    private double rate;
    private float fRate;
    private int[] arrA;
    private Long[] arrAs = new Long[10];
    private List<String> listB;
    private List<String> listBs = new ArrayList<>();
    private Map<String,String> maps;
    private Map<String,String> mapCs = new LinkedHashMap<>();
    private Status status;
    private BigDecimal price;
    private Date time;
    private Timestamp tsp;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public int[] getArrA() {
        return arrA;
    }

    public void setArrA(int[] arrA) {
        this.arrA = arrA;
    }

    public Long[] getArrAs() {
        return arrAs;
    }

    public void setArrAs(Long[] arrAs) {
        this.arrAs = arrAs;
    }

    public List<String> getListB() {
        return listB;
    }

    public void setListB(List<String> listB) {
        this.listB = listB;
    }

    public List<String> getListBs() {
        return listBs;
    }

    public void setListBs(List<String> listBs) {
        this.listBs = listBs;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Map<String, String> getMapCs() {
        return mapCs;
    }

    public void setMapCs(Map<String, String> mapCs) {
        this.mapCs = mapCs;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public float getfRate() {
        return fRate;
    }

    public void setfRate(float fRate) {
        this.fRate = fRate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Timestamp getTsp() {
        return tsp;
    }

    public void setTsp(Timestamp tsp) {
        this.tsp = tsp;
    }
}
