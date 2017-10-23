package com.iana.application.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private SessionFactory sessionFactory = buildSessionFactory();

    public SessionFactory getSessionFactory(){
            return this.sessionFactory;
    }

    private SessionFactory buildSessionFactory(){
        Configuration cf = new Configuration().configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
        srb.applySettings(cf.getProperties());
        ServiceRegistry sr = srb.build();
        this.sessionFactory = cf.buildSessionFactory(sr);
        return sessionFactory;
    }

}
