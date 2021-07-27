package com.payment.repository;

import com.payment.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
  @Query(value = "SELECT * FROM accounts WHERE client_id = :id",
      nativeQuery = true)
  List<Account> getAccountsByClientId(Long id);

  Account getByAccountId(Long id);

  @Modifying
  @Query(value = "update accounts SET balance = balance + :value where id = :id",
      nativeQuery = true)
  void updateBalance(Long id, Double value);
}
