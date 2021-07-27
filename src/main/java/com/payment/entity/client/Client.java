package com.payment.entity.client;

import com.payment.entity.account.Account;
import com.payment.entity.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "clients")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private Long clientId;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
  private List<Account> accounts = new ArrayList<>();

  @OneToMany(mappedBy = "payer", fetch = FetchType.LAZY)
  private List<Payment> outputPayments = new ArrayList<>();

  @OneToMany(mappedBy = "recipient", fetch = FetchType.LAZY)
  private List<Payment> inputPayments = new ArrayList<>();
}
