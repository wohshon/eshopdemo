package com.redhat.app.customer.domain;

import com.redhat.app.customer.domain.model.CustomerDomainObject;

public interface CustomerService {
    
    public void register(CustomerDomainObject customer);
    public void updateParticulars();
    public void deregister();
    public void viewOrders();
    public void purchase();

    
}