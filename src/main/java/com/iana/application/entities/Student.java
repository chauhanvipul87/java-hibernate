package com.iana.application.entities;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "COLLEGE")
    private String college;

    @Embedded
    private StudentAddress studentAddress;


    /* If you would like to update the join column of embeddable class in derived class then you should have to use @AssociationOverrides */
    /*@AssociationOverrides({
            @AssociationOverride(name = "cityId", joinColumns =  @JoinColumn(name = "E_CITY_ID")) })*/

    /* ---Note: Please make sure that name should be java field name not the column name that we defined in our Embeddable object otherwise it gives me an error**/
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "LOCAL_ADDR_STREET_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "LOCAL_ADDR_CITY")),
            @AttributeOverride(name = "state", column = @Column(name = "LOCAL_ADDR_STATE")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "LOCAL_ADDR_ZIP_CODE")),
    })
    private StudentAddress localStudentAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }

    public StudentAddress getLocalStudentAddress() {
        return localStudentAddress;
    }

    public void setLocalStudentAddress(StudentAddress localStudentAddress) {
        this.localStudentAddress = localStudentAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", college='" + college + '\'' +
                ", studentAddress=" + studentAddress +
                ", localStudentAddress=" + localStudentAddress +
                '}';
    }
}
