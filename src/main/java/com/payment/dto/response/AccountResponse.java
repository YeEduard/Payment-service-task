package com.payment.dto.response;

import com.payment.entity.account.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AccountResponse {
  private Long accountId;
  private String accountNum;
  private String accountType;
  private Double balance;

  public AccountResponse(Account a) {
    this.accountId = a.getAccountId();
    this.accountNum = a.getAccountNum();
    this.accountType = a.getAccountType();
    this.balance = a.getBalance();
  }
}
