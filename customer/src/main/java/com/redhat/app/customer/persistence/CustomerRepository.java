package com.redhat.app.customer.persistence;

import java.util.List;

import com.redhat.app.customer.persistence.model.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> 
{
    List<Customer> findByEmail(String email);
}
