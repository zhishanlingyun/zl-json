package com.zl.dm.json.bean;

public enum Status {
    START(1,"开始"),RUNNING(2,"执行中");

    private int state;
    private String desc;

    Status(int state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public int getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }
}
