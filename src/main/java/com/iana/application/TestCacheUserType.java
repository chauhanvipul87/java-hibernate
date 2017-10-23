package com.iana.application;


import com.iana.application.entities.UserType;
import com.iana.application.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCacheUserType {

    //Dummy Record creation ...
    private static void dummyDataCreation(){

        Session session = new HibernateUtil().getSessionFactory().openSession();
        //once transient object attached to hibernate, it became persistent object state
        Transaction tx = session.beginTransaction();

        List<String> listUserType = new ArrayList<String>();
        listUserType.add("ADMIN");
        listUserType.add("SUPER ADMIN");
        listUserType.add("USER");
        listUserType.add("INTERNAL USER");
        listUserType.add("CLIENT");
        listUserType.add("WEB SERVICE USER");

        for (String userTypeStr: listUserType) {

            //transient object state
            UserType userType = new UserType();
            userType.setUserTypeName(userTypeStr);
            userType.setCreatedDate(new Date());
            userType.setModifiedDateTime(new Date());
            userType.setCreatedDateNormal(new Date());
            userType.setCreatedTime(new Date());
            userType.setModifiedDateWithoutTime(new Date());
            userType.setDeleted(true);
            userType.setActive('Y');

            session.save(userType);
        }

        tx.commit();

        System.out.println("UserType added successfully.....!!");
        session.close();
    }

    public static void main(String[] args) {

        //dummyDataCreation();
        fetchAllUserTypes();

    }

    private static void fetchAllUserTypes() {
        Session session = new HibernateUtil().getSessionFactory().openSession();

        UserType userType =  (UserType) session.get(UserType.class, 1L);
        System.out.println("1.--- userType = " + userType);


         userType =  (UserType) session.get(UserType.class, 1L);
        System.out.println("2.--- userType = " + userType);


        userType =  (UserType) session.get(UserType.class, 3L);
        System.out.println("3.--- userType = " + userType);

        session.close();
    }


}
