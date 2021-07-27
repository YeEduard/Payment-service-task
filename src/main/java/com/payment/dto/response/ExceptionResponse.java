package com.payment.dto.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExceptionResponse {
  private String message;
  private Integer statusCode;
}
