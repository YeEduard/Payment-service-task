package com.payment.entity.account;

import com.payment.entity.client.Client;
import com.payment.entity.payment.Payment;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "accounts")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private Long accountId;

  @Column(name = "account_num")
  private String accountNum;

  @Column(name = "account_type")
  private String accountType;

  @Column(name = "balance")
  private Double balance;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  private Client client;

  @OneToMany(mappedBy = "sourceAcc", fetch = FetchType.LAZY)
  private List<Payment> paymentsInput = new ArrayList<>();

  @OneToMany(mappedBy = "destinationAcc", fetch = FetchType.LAZY)
  private List<Payment> outputPayments = new ArrayList<>();
}
