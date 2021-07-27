package com.payment.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class PaymentSearchRequest {
  private Long payerId;
  private Long recipientId;
  private Long sourceAccountId;
  private Long destinationAccountId;
}
