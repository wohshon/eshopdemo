package com.redhat.app.customer.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@MappedSuperclass //cannot use this as I model it as a relationshop in customer
@Entity
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String instituteId;
    private String accountNumber;
    private String accountId; 
    private String accountHolderName; 
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)    
    private Customer customer;
}