package com.payment.service;

import com.payment.dto.request.PaymentRequest;
import com.payment.dto.request.PaymentSearchRequest;
import com.payment.dto.response.ClientSearchResponse;
import com.payment.dto.response.PaymentResponse;
import com.payment.dto.response.PaymentSearchResponse;
import com.payment.entity.account.Account;
import com.payment.entity.client.Client;
import com.payment.entity.payment.Payment;
import com.payment.exception.NoBalanceException;
import com.payment.repository.AccountRepository;
import com.payment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PaymentService {
  private final PaymentRepository paymentRepository;
  private final AccountRepository accountRepository;

  @Transactional
  public PaymentResponse createPayment(PaymentRequest pr) {
    Account sourceAcc = accountRepository.getOne(pr.getSourceAccountId());
    Account destAcc = accountRepository.getOne(pr.getDestinationAccountId());
    Client payer = sourceAcc.getClient();
    Client recipient = destAcc.getClient();

    if (sourceAcc.getBalance() - pr.getAmount() < 0) throw new NoBalanceException();

    accountRepository.updateBalance(sourceAcc.getAccountId(), -pr.getAmount());
    accountRepository.updateBalance(destAcc.getAccountId(), pr.getAmount());
    Payment save = paymentRepository.save(pr.toEntity(payer, recipient, sourceAcc, destAcc));
    return new PaymentResponse(save.getPaymentId());
  }

  @Transactional
  public List<PaymentResponse> createPayments(List<PaymentRequest> prl) {
    return prl.stream()
        .map(this::createPayment)
        .collect(Collectors.toList());
  }

  public List<PaymentSearchResponse> search(PaymentSearchRequest psr) {
    return paymentRepository.search(
        psr.getPayerId(),
        psr.getRecipientId(),
        psr.getSourceAccountId(),
        psr.getDestinationAccountId()
    )
        .stream()
        .map(PaymentSearchResponse::fromPayment)
        .collect(Collectors.toList());
  }
}
