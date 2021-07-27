package com.payment.service;

import com.payment.dto.response.AccountResponse;
import com.payment.entity.account.Account;
import com.payment.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountService {
  private final AccountRepository accountRepository;

  public Account getById(Long id) {
    return accountRepository.getByAccountId(id);
  }

  public List<AccountResponse> getByClientId(Long id) {
    return accountRepository.getAccountsByClientId(id)
        .stream()
        .map(AccountResponse::new)
        .collect(Collectors.toList());
  }
}
