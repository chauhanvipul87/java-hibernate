package com.iana.application;

import com.iana.application.entities.student_entities.SchoolAddress;
import com.iana.application.entities.student_entities.Student;
import com.iana.application.entities.student_entities.StudentAddress;
import com.iana.application.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CrudStudentDemo {

    private  static void addNewStudent(){

        System.out.println("in addNewStudent....:");
        Session session = new HibernateUtil().getSessionFactory().openSession();
        SchoolAddress schoolAddress = new SchoolAddress("BillaBong School","Vadodara");
        SchoolAddress schoolAddress1 = new SchoolAddress("Kidzee School","KareliBaug");
        //StudentAddress studentAddress = new StudentAddress("Opp.Indian Oil Petrol Pump","Vadodara","Gujarat","390011");

        //transient object state
        Student std = new Student();
        std.setName("Jamil");
        std.setDepartment("ECE");
        std.setCollege("SKCET");
        std.getSchoolAddress().add(schoolAddress);
        std.getSchoolAddress().add(schoolAddress1);
       // std.setStudentAddress(studentAddress);
        //once transient object attached to hibernate, it became persistent object state
        Transaction tx = session.beginTransaction();
        session.save(std);
        tx.commit();
        //ready for the garbage collector- persistent object became detached ohject state
        session.evict(std);

        System.out.println("Student added successfully.....!!");
        session.close();

    }

    private  static void findAllStudent(){

        Session session = new HibernateUtil().getSessionFactory().openSession();
        List<Student> students = session.createCriteria(Student.class).list();
        pritingList(students);
        System.out.println("Student listed successfully.....!!");
        session.close();

    }

    private  static void findOneStudent(){

        Session session = new HibernateUtil().getSessionFactory().openSession();

        Student student = (Student) session.get(Student.class,1L);
        System.out.println(student);

        student = (Student) session.get(Student.class,2L);
        System.out.println(student);

        System.out.println("Student 1 listed successfully.....!!");
        session.close();

    }

    private  static void deleteStudent(){

        Session session = new HibernateUtil().getSessionFactory().openSession();
        Student s = new Student();
        s.setId(1L);

        Transaction tx = session.beginTransaction();

        session.delete(s);

        tx.commit();
        System.out.println("Student deleted successfully.....!!");
        session.close();

    }

    private static void updateStudent() {
        Session session = new HibernateUtil().getSessionFactory().openSession();

        Student s = (Student) session.get(Student.class,2L);
        s.setName("Vipul");

        Transaction tx = session.beginTransaction();

        session.save(s);

        tx.commit();
        System.out.println("Student details updated successfully.....!!");
        session.close();
    }

    private static void testCustomQueriesForStudent() {

        Session session = new HibernateUtil().getSessionFactory().openSession();

        Query query = session.createQuery("from Student where id > 1 order by id DESC ");
        List<Student> students = query.list();
        System.out.println(students);
        pritingList(students);

        System.out.println("Student with custom query- listed successfully.....!!");


        query = session.createQuery("from Student where id > 1 group by name");
        students = query.list();
        System.out.println(students);
        pritingList(students);
        System.out.println("Student with custom query having group by- listed successfully.....!!");


        query = session.createQuery("from Student where id = 2 and name = :name");
        query.setParameter("name","vipul");
        students = query.list();
        System.out.println(students);
        pritingList(students);
        System.out.println("Student with custom query with and and parameter passing- listed successfully.....!!");

        query = session.createQuery("SELECT name from Student where id > 1 order by id DESC ");
        List<String> studentList = query.list();
        System.out.println(studentList);
        for (String e:studentList) {
            System.out.println(e);
        }
        System.out.println("Select specific field using custom query- listed successfully.....!!");

        session.close();

    }

    private static void pritingList(List<Student> students) {
        System.out.println("---printing...List");
        for (Student e:students) {
            System.out.println(e);
            if(e.getSchoolAddress().size() >= 0)
                for (SchoolAddress st: e.getSchoolAddress()) {
                    System.out.println("students school address= " + st);
                }

        }
    }

    private static void testEmbeddableFunctionality() {

        Session session = new HibernateUtil().getSessionFactory().openSession();

        StudentAddress studentAddress = new StudentAddress("Opp.Indian Oil Petrol Pump","Vadodara","Gujarat","390011");


        //transient object state
        Student std = new Student();
        std.setName("Vipul");
        std.setDepartment("ECE");
        std.setCollege("SKCET");
        std.setStudentAddress(studentAddress);
        std.setLocalStudentAddress(studentAddress);



        //once transient object attached to hibernate, it became persistent object state
        Transaction tx = session.beginTransaction();
        session.save(std);
        tx.commit();
        //ready for the garbage collector- persistent object became detached ohject state
        session.evict(std);

        System.out.println("Student added successfully.....!!");
        session.close();
    }

    public static void main(String[] args) {

        //add new student
        addNewStudent();
        //addNewStudent();
        //addNewStudent();

        //fetch all the students
        findAllStudent();

        //get one student information
        //findOneStudent();

        // delete one student from database
        //deleteStudent();

        //update student information
        //updateStudent();

        //custom query
        //testCustomQueriesForStudent();

        //test embeddable
        //testEmbeddableFunctionality();


    }



}
