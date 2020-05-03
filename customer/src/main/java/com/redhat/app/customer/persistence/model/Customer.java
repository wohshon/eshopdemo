package com.redhat.app.customer.persistence.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Component("jpaEntity")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Date registeredOn;

    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses;

    @Override
    public String toString() {
        return this.name;
    }
    @Enumerated(EnumType.STRING)
    private CUSTOMER_STATUS status;

    public enum CUSTOMER_STATUS {
        NEW,
        INACTIVE,
        SUSPENDED,
        DEREGISTERED,
        ACTIVE
    }    
}
