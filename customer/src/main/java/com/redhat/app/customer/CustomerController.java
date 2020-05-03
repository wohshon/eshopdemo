package com.redhat.app.customer;

import org.springframework.web.bind.annotation.RestController;

import com.redhat.app.customer.domain.model.CustomerDomainObject;
import com.redhat.app.customer.domain.model.CustomerRegisterObject;

import java.util.Iterator;

import com.redhat.app.customer.domain.CustomerService;
import com.redhat.app.customer.persistence.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class CustomerController {

    @Autowired
    @Qualifier("domain")
    CustomerService customer;

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
    @RequestMapping("/echo/{name}")
    @ResponseBody
    public String index(@PathVariable String name) {
        log.info("name "+name);
        //this.customer.register();

        return "Hello "+name;
    }

    @PostMapping(value="/register", consumes = "application/json")
    public void register(@RequestBody CustomerRegisterObject cust) {
        log.info("customer "+cust.getId());
        log.info("customer "+cust.getName());
        log.info("customer addr "+cust.getAddresses().size());
        log.info("customer payment "+cust.getPaymentInfos().size());
        
        log.info("customer "+cust);
        
        customer.register((CustomerDomainObject)cust);
    }
    
    @PostMapping(value="/update", consumes = "application/json")
    public void update(@RequestBody CustomerRegisterObject cust) {
        log.info("customer "+cust.getId());
        log.info("customer "+cust.getName());
        log.info("customer addr "+cust.getAddresses().size());
        log.info("customer "+cust);
        
        customer.updateParticulars((CustomerDomainObject)cust);
    }
}