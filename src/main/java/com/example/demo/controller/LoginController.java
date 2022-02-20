package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Principal user) {
        List<Customer> customers = customerRepository.findByEmail(user.getName());
        if (CollectionUtils.isEmpty(customers)) {
            return null;
        } else {
            return customers.get(0);
        }
    }
}
