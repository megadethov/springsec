package com.example.demo.config;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomUserDetails;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = customerRepository.findByEmail(username);
        if (CollectionUtils.isEmpty(customers)) throw new UsernameNotFoundException("User details not found for the user: " + username);

        return new CustomUserDetails(customers.get(0));
    }
}
