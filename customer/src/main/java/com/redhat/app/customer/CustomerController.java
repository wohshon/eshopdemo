package com.redhat.app.customer;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class CustomerController {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
    @RequestMapping("/foos/{name}")
    @ResponseBody
    public String index(@PathVariable String name) {
    	log.info("name "+name);
        return "Hello "+name;
    }
    

}