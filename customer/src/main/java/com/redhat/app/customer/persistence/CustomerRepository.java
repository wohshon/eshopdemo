package com.redhat.app.customer.persistence;

import com.redhat.app.customer.persistence.model.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> 
{

}
