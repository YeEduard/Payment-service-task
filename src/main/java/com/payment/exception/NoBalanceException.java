package com.payment.exception;

public class NoBalanceException extends RuntimeException {
  public NoBalanceException() {
    super("Unable to make payment, not enough funds to write off");
  }
}
