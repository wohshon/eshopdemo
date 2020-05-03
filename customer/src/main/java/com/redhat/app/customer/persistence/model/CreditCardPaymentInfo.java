package com.redhat.app.customer.persistence.model;

import java.util.Date;

import javax.persistence.Entity;
@Entity
public class CreditCardPaymentInfo extends PaymentInfo{
    private Date expiryDate;
    private String cvs;

}