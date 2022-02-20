package com.example.demo.controller;

import com.example.demo.model.AccountTransactions;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountTransactionsRepository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class BalanceController {

	private final AccountTransactionsRepository accountTransactionsRepository;

	public BalanceController(AccountTransactionsRepository accountTransactionsRepository) {
		this.accountTransactionsRepository = accountTransactionsRepository;
	}

	@PostMapping("/my-balance")
	public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
		List<AccountTransactions> accountTransactions = accountTransactionsRepository.
				findByCustomerIdOrderByTransactionDtDesc(customer.getId());
		if (CollectionUtils.isEmpty(accountTransactions)) {
			return Collections.emptyList();
		}else {
			return accountTransactions;
		}
	}
}
