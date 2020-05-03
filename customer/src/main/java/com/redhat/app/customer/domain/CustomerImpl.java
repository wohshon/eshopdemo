package com.redhat.app.customer.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.redhat.app.customer.domain.model.CustomerDomainObject;
import com.redhat.app.customer.domain.model.CustomerRegisterObject;
import com.redhat.app.customer.persistence.CustomerRepository;
import com.redhat.app.customer.persistence.model.Address;
import com.redhat.app.customer.persistence.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component("domain")
public class CustomerImpl implements CustomerService{

//    @Autowired
//    @Qualifier("jpaEntity")
//    private Customer customer;
Logger log = LoggerFactory.getLogger(this.getClass().getName());
@Autowired
CustomerRepository customerRepository;

    @Override
    public void deregister() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void purchase() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void register(CustomerDomainObject customer) {
        
        Customer saveCust= mapper(customer);
        saveCust.setRegisteredOn(new Date());
        saveCust.setStatus(Customer.CUSTOMER_STATUS.NEW);
        customerRepository.save(saveCust);
        log.info("saved "+saveCust.getName());
    }

    private Customer mapper(CustomerDomainObject dto) {
        Customer saveCust= new Customer();
        log.info("mapper "+dto.getClass());
        if (dto.getClass().equals(CustomerRegisterObject.class)) {
            log.info("ok got the class");
            CustomerRegisterObject cro = (CustomerRegisterObject)dto;
            saveCust.setName(cro.getName());
            saveCust.setEmail(cro.getEmail());
            saveCust.setPhone(cro.getPhone());
            Iterator<Address> itr = cro.getAddresses().iterator();
            //Set<Address> saveAddrSet= new HashSet<Address>();
            while (itr.hasNext()) {
                log.info("update cust to address "+saveCust.getName());
                itr.next().setCustomer(saveCust);
                //Address addr= itr.next();
                //addr.setCustomer(saveCust);
                //saveAddrSet.add(addr);
                //saveCust.setAddresses(saveAddrSet);
            }
            saveCust.setAddresses(cro.getAddresses());
        }

        return saveCust; 
    }
    @Override
    public void updateParticulars(CustomerDomainObject dto) {
        //get entity
        Customer cust = customerRepository.findByEmail(dto.getEmail()).get(0);
        log.info("found "+cust.getName());
        
        
    }
    @Override
    public void viewOrders() {
        // TODO Auto-generated method stub
        
    }
}