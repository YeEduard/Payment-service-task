package com.payment.entity.payment;


import com.payment.entity.account.Account;
import com.payment.entity.client.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "payments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private Long paymentId;

  @Column(name = "timestamp")
  @Temporal(TemporalType.TIMESTAMP)
  private Date timeStamp;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "source_acc_id")
  private Account sourceAcc;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dest_acc_id")
  private Account destinationAcc;

  private Double amount;

  @Column(name = "src_acc_num")
  private String sourceAccountNum;

  @Column(name = "dest_acc_num")
  private String destinationAccountNum;

  private String reason;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payer_id")
  private Client payer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recipient_id")
  private Client recipient;
}
