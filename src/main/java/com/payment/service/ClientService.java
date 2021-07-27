package com.payment.service;

import com.payment.dto.request.ClientRequest;
import com.payment.dto.response.ClientResponse;
import com.payment.entity.client.Client;
import com.payment.repository.AccountRepository;
import com.payment.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClientService {
  private final ClientRepository clientRepository;
  private final AccountRepository accountRepository;

  private Client saveClient(ClientRequest cr) {
    Client saveClient = clientRepository.save(cr.toEntity());
    accountRepository.saveAll(cr.getAccounts()
        .stream()
        .map(a -> a.toEntity(saveClient))
        .collect(Collectors.toList()));
    return saveClient;
  }

  public ClientResponse create(ClientRequest cr) {
    return new ClientResponse(saveClient(cr));
  }

  public List<ClientResponse> create(List<ClientRequest> crl) {
    List<Client> saveClients = clientRepository.saveAll(
        crl.stream()
            .map(this::saveClient)
            .collect(Collectors.toList())

    );

    return saveClients
        .stream()
        .map(ClientResponse::new)
        .collect(Collectors.toList());
  }
}
