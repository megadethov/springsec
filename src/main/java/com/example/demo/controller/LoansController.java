package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Loans;
import com.example.demo.repository.LoanRepository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class LoansController {

    private final LoanRepository loanRepository;

    public LoansController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostMapping("/my-loans")
    public List<Loans> getLoanDetails(@RequestBody Customer customer) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
        if (CollectionUtils.isEmpty(loans)) {
            return Collections.emptyList();
        } else {
            return loans;
        }
    }
}
