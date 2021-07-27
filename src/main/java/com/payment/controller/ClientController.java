package com.payment.controller;

import com.payment.dto.request.ClientRequest;
import com.payment.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("api/v1/clients")
@RestController
public class ClientController {
  public ClientService clientService;

  @PostMapping("create")
  public ResponseEntity<?> create(@RequestBody ClientRequest cr) {
    return ResponseEntity.status(201)
        .body(clientService.create(cr));
  }

  @PostMapping("createMany")
  public ResponseEntity<?> create(@RequestBody List<ClientRequest> crl) {
    return ResponseEntity.status(201)
        .body(clientService.create(crl));
  }
}
