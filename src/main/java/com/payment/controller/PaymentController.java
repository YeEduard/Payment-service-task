package com.payment.controller;

import com.payment.dto.request.PaymentRequest;
import com.payment.dto.request.PaymentSearchRequest;
import com.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("api/v1/payments")
@RestController
public class PaymentController {
  private final PaymentService paymentService;

  @PostMapping("create")
  public ResponseEntity<?> createPayment(@RequestBody PaymentRequest pr) {
    return ResponseEntity.status(201)
        .body(paymentService.createPayment(pr));
  }

  @PostMapping("createMany")
  public ResponseEntity<?> createPayments(@RequestBody List<PaymentRequest> prl) {
    return ResponseEntity.status(201)
        .body(paymentService.createPayments(prl));
  }

  @PostMapping("search")
  public ResponseEntity<?> search(@RequestBody PaymentSearchRequest psr) {
    return ResponseEntity.status(200)
        .body(paymentService.search(psr));
  }
}
