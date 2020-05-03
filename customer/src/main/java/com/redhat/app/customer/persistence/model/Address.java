package com.redhat.app.customer.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
    private String streetName;
    private String country;
    private String buildingName;
    private String unit;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private ADDRESS_TYPE type;

    public enum ADDRESS_TYPE {
        SHIPPING,
        MAILING
    }
}