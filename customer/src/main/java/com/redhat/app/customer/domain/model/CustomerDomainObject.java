package com.redhat.app.customer.domain.model;

import java.util.Set;

import com.redhat.app.customer.persistence.model.Address;
import com.redhat.app.customer.persistence.model.PaymentInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDomainObject {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Set<Address> addresses;
    private Set<PaymentInfo> paymentInfos;

    
    @Override
    public String toString() {
        
        return this.id+" "+this.name+" "+this.email;
    }
}