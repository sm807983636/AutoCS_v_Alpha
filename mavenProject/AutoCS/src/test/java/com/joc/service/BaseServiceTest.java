package com.joc.service;


import org.springframework.orm.hibernate3.HibernateTemplate;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

@SpringApplicationContext( {"applicationContext.xml" })
public class BaseServiceTest extends UnitilsTestNG {
    @SpringBean("hibernateTemplate")
    public HibernateTemplate hibernateTemplate;

}