package com.joc.domain;

import javax.persistence.*;

@Entity
@Table(name = "departmanagement")       //系负责人表
public class Departmanagement extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    protected int departId;

    @Column(name = "user_name")
    protected String departUserName;

    @Column(name = "password")
    protected String departPassword;

    @Column(name = "department")
    protected String departDepartment;

    @Column(name = "name")
    protected String departName;

    @Column(name = "telephone")
    protected String departTelephone;

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public String getDepartUserName() {
        return departUserName;
    }

    public void setDepartUserName(String departUserName) {
        this.departUserName = departUserName;
    }

    public String getDepartPassword() {
        return departPassword;
    }

    public void setDepartPassword(String departPassword) {
        this.departPassword = departPassword;
    }

    public String getDepartDepartment() {
        return departDepartment;
    }

    public void setDepartDepartment(String departDepartment) {
        this.departDepartment = departDepartment;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartTelephone() {
        return departTelephone;
    }

    public void setDepartTelephone(String departTelephone) {
        this.departTelephone = departTelephone;
    }
}
