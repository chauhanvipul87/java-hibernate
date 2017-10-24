package com.iana.application.test;


import com.iana.application.entities.relations.Customer;
import com.iana.application.entities.relations.Status;
import com.iana.application.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TestRelationsShip {

    public TestRelationsShip(){

    }

    private void testCustomerStatusBiDirectionalRelationShip(){
        //addNewCustomerAndStatus();
        //fetchCustomerAndStatusRecords();

    }

    private void fetchCustomerAndStatusRecords() {
        Session session = new HibernateUtil().getSessionFactory().openSession();
        //list customer with status
        List<Customer> listCutomer =  session.createCriteria(Customer.class).list();
        System.out.println("listCutomer = " + listCutomer);

        //now accessing status
        List<Status> listStatus = session.createCriteria(Status.class).list();
        System.out.println("listStatus = " + listStatus);
        for (Status s: listStatus ) {
            System.out.println("Customer's status details :("+ s.getStatusId() +","+s.getStatus()+") "  +"--"+"No of customer found: "+s.getListCustomer().size());
        }

        session.close();
    }


    private void addNewCustomerAndStatus() {
        Session session = new HibernateUtil().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        for (int i = 1 ;i <= 10 ;i++){
            //save and fetch records
            Status st = new Status();
            st.setStatus("ACTIVE"+i);

            Customer customer = new Customer();
            customer.setCustName("John"+i);
            customer.setStatus(st);
            customer.setEmail("john@yahoo.com"+i);
            session.save(st);
            session.save(customer);
        }

        tx.commit();
        session.close();
        System.out.println("done....");
    }


    public static void main(String[] args) {
            new TestRelationsShip().testCustomerStatusBiDirectionalRelationShip();
    }
}
