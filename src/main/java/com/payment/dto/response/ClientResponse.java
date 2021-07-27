package com.payment.dto.response;

import com.payment.entity.client.Client;
import lombok.Data;

@Data
public class ClientResponse {
  private Long clientId;

  public ClientResponse(Client c) {
    this.clientId = c.getClientId();
  }
}
