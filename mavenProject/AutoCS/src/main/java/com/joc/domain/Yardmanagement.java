package com.joc.domain;

import javax.persistence.*;

@Entity
@Table(name = "yardmanagement")          //院负责人表
public class Yardmanagement extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    protected int yardId;

    @Column(name = "user_name")
    protected String yardUserName;

    @Column(name = "password")
    protected String yardPassword;

    @Column(name = "name")
    protected String yardName;

    @Column(name = "telephone")
    protected String yardTelephone;

    public int getYardId() {
        return yardId;
    }

    public void setYardId(int yardId) {
        this.yardId = yardId;
    }

    public String getYardUserName() { return yardUserName; }

    public void setYardUserName(String yardUserName) {
        this.yardUserName = yardUserName;
    }

    public String getYardPassword() {
        return yardPassword;
    }

    public void setYardPassword(String yardPassword) {
        this.yardPassword = yardPassword;
    }

    public String getYardName() {
        return yardName;
    }

    public void setYardName(String yardName) {
        this.yardName = yardName;
    }

    public String getYardTelephone() {
        return yardTelephone;
    }

    public void setYardTelephone(String yardTelephone) {
        this.yardTelephone = yardTelephone;
    }

}
