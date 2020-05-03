package com.redhat.app.customer.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDomainObject {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    
    @Override
    public String toString() {
        
        return this.id+" "+this.name+" "+this.email;
    }
}