package com.payment.dto.response;

import com.payment.entity.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class PaymentSearchResponse {
  private Long paymentId;
  private Date timestamp;
  private String sourceAccountNum;
  private String destAccountNum;
  private Double amount;
  private ClientSearchResponse payer;
  private ClientSearchResponse recipient;

  public static PaymentSearchResponse fromPayment(Payment p) {
    return new PaymentSearchResponse(
        p.getPaymentId(),
        p.getTimeStamp(),
        p.getSourceAccountNum(),
        p.getDestinationAccountNum(),
        p.getAmount(),
        new ClientSearchResponse(p.getPayer().getFirstName(), p.getPayer().getLastName()),
        new ClientSearchResponse(p.getRecipient().getFirstName(), p.getRecipient().getLastName())
    );
  }
}
