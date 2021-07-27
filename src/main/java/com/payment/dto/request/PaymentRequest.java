package com.payment.dto.request;

import com.payment.entity.account.Account;
import com.payment.entity.client.Client;
import com.payment.entity.payment.Payment;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@EqualsAndHashCode
public class PaymentRequest {
  @NotNull
  private Long sourceAccountId;
  @NotNull
  private Long destinationAccountId;
  @NotNull
  private Double amount;
  @NotNull
  private String reason;

  public Payment toEntity(Client payer, Client recipient, Account sourceAcc, Account destAcc) {
    return Payment.builder()
        .payer(payer)
        .recipient(recipient)
        .sourceAcc(sourceAcc)
        .destinationAcc(destAcc)
        .sourceAccountNum(sourceAcc.getAccountNum())
        .destinationAccountNum(destAcc.getAccountNum())
        .amount(this.amount)
        .reason(this.reason)
        .timeStamp(new Date())
        .build();
  }
}
