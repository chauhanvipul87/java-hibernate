package com.iana.application.utils;

import com.iana.application.entities.caching.UserType;
import com.iana.application.entities.relations.Customer;
import com.iana.application.entities.relations.Status;
import com.iana.application.entities.student_entities.SchoolAddress;
import com.iana.application.entities.student_entities.Student;
import com.iana.application.entities.student_entities.StudentAddress;
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
        Configuration cf = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                //.addAnnotatedClass(Order.class)
                //.addAnnotatedClass(OrderDetail.class)
                .addAnnotatedClass(SchoolAddress.class)
                .addAnnotatedClass(Status.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentAddress.class)
                .addAnnotatedClass(UserType.class)
                ;

        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
        srb.applySettings(cf.getProperties());
        ServiceRegistry sr = srb.build();
        this.sessionFactory = cf.buildSessionFactory(sr);
        return sessionFactory;
    }

}
