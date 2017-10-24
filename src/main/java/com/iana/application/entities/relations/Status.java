package com.iana.application.entities.relations;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="STATUS_ID")
    private Long statusId;

    @Column(name ="STATUS")
    private String status;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<Customer> listCustomer = new ArrayList<Customer>();

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }



}
