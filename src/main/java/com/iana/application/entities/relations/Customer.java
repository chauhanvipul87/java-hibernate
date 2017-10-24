package com.iana.application.entities.relations;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="CUST_ID")
    private Long custId;

    @ManyToOne
    @JoinColumn(name ="STATUS_ID")
    private Status status;
}
