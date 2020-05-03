package com.redhat.app.customer.domain.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomerRegisterObject extends CustomerDomainObject{
    private Date registeredOn;

    @Override
    public String toString() {
        return super.toString() + " "+this.registeredOn ;
    }
}