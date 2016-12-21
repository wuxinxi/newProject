package com.wxx.pswnote.bean;

/**
 * 作者：Tangren_ on 2016/12/18 11:37.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class SpendBean {
    private int id;
    private String type;

    public SpendBean(int id, String type) {
        this.id = id;
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
