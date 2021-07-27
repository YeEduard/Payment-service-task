package com.payment.repository;

import com.payment.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

  @Query(nativeQuery = true,
      value = "SELECT * FROM payments WHERE payer_id = :payerId " +
          "AND recipient_id = :recipientId " +
          "AND source_acc_id = :sourceAccId " +
          "AND dest_acc_id = :destAccId")
  List<Payment> search(Long payerId, Long recipientId, Long sourceAccId, Long destAccId);
}
