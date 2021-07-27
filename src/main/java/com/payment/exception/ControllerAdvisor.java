package com.payment.exception;

import com.payment.dto.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class ControllerAdvisor extends ResponseEntityExceptionHandler {

  @ExceptionHandler(HttpStatusCodeException.class)
  ResponseEntity<ExceptionResponse> handleHttpStatusCodeException(HttpStatusCodeException ex, HttpServletRequest request) {
    return ResponseEntity.status(ex.getStatusCode())
        .body(new ExceptionResponse(ex.getMessage(), ex.getStatusCode().value()));
  }

  @ExceptionHandler(NoBalanceException.class)
  ResponseEntity<String> handleNoBalanceException(NoBalanceException ex) {
    return ResponseEntity.status(200)
        .body(ex.getMessage());
  }
}
