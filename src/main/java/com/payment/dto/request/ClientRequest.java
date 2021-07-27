package com.payment.dto.request;


import com.payment.entity.client.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ClientRequest {
  @Size(min = 2)
  private String firstName;
  @Size(min = 2)
  private String lastName;
  @NotEmpty
  private List<AccountRequest> accounts;

  public Client toEntity() {
    return Client.builder()
        .firstName(this.firstName)
        .lastName(this.lastName)
        .accounts(new ArrayList<>())
        .build();
  }
}
