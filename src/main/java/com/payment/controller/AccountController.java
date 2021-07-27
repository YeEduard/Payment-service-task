package com.payment.controller;


import com.payment.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("api/v1/accounts")
@RestController
public class AccountController {
  private final AccountService accountService;

  @GetMapping("{client_id}")
  public ResponseEntity<?> getAccountsByClientId(@PathVariable("client_id") Long id) {
    return ResponseEntity.ok(accountService.getByClientId(id));
  }
}
