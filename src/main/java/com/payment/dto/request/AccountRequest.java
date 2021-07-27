package com.payment.dto.request;

import com.payment.entity.account.Account;
import com.payment.entity.client.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountRequest {
  private String accountNum;
  private String accountType;
  private Double balance;

  public Account toEntity(Client c) {
    return Account.builder()
        .client(c)
        .accountNum(this.accountNum)
        .accountType(this.accountType)
        .balance(this.balance)
        .build();
  }
}
