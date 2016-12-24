package com.wxx.pswnote.bean;
 /*
******************* Copyright (c) ***********************\
**
**         (c) Copyright  2016 , 唐人
**                  All Rights Reserved
**
**                    By(唐人)
**                www.wuxinxi.github.io
**
**                       _oo0oo_
**                      o8888888o
**                      88" . "88
**                      (| -_- |)
**                      0\  =  /0
**                    ___/`---'\___
**                  .' \\|     |// '.
**                 / \\|||  :  |||// \
**                / _||||| -:- |||||- \
**               |   | \\\  -  /// |   |
**               | \_|  ''\---/''  |_/ |
**               \  .-\__  '-'  ___/-. /
**             ___'. .'  /--.--\  `. .'___
**          ."" '<  `.___\_<|>_/___.' >' "".
**         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
**         \  \ `_.   \_ __\ /__ _/   .-` /  /
**     =====`-.____`.___ \_____/___.-`___.-'=====
**                       `=---='
**
**
**     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
**
**               佛祖保佑         永无BUG
**
**
**                   南无本师释迦牟尼佛
**

**----------------------类信息------------------------
** 版    本: V0.1
**
**Created by Tangren on 2016/12/20 0020.
**Email:wu_tangren@163.com
**TODO:用一句话概括
**
******************* End of Head **********************\
 */


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Spend {
    @Id(autoincrement = true)
    private Long id;
    private int icon;
    private String spendmoney;
    private String incomemoney;
    private String spendtype;
    private String incometype;
    private String time;
    private String date;


    @Generated(hash = 734867630)
    public Spend(Long id, int icon, String spendmoney, String incomemoney,
            String spendtype, String incometype, String time, String date) {
        this.id = id;
        this.icon = icon;
        this.spendmoney = spendmoney;
        this.incomemoney = incomemoney;
        this.spendtype = spendtype;
        this.incometype = incometype;
        this.time = time;
        this.date = date;
    }


    @Generated(hash = 698462423)
    public Spend() {
    }
    

    @Override
    public String toString() {
        return "Spend{" +
                "id=" + id +
                ", icon=" + icon +
                ", spendmoney=" + spendmoney +
                ", incomemoney=" + incomemoney +
                ", spendtype='" + spendtype + '\'' +
                ", incometype='" + incometype + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public int getIcon() {
        return this.icon;
    }


    public void setIcon(int icon) {
        this.icon = icon;
    }


    public String getSpendmoney() {
        return this.spendmoney;
    }


    public void setSpendmoney(String spendmoney) {
        this.spendmoney = spendmoney;
    }


    public String getIncomemoney() {
        return this.incomemoney;
    }


    public void setIncomemoney(String incomemoney) {
        this.incomemoney = incomemoney;
    }


    public String getSpendtype() {
        return this.spendtype;
    }


    public void setSpendtype(String spendtype) {
        this.spendtype = spendtype;
    }


    public String getIncometype() {
        return this.incometype;
    }


    public void setIncometype(String incometype) {
        this.incometype = incometype;
    }


    public String getTime() {
        return this.time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public String getDate() {
        return this.date;
    }


    public void setDate(String date) {
        this.date = date;
    }
}
