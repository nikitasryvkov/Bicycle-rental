package com.example.rental.repositories;

import java.util.Optional;

import com.example.rental.domain.Client;

public interface ClientRepository {

  Client save(Client client);
  Optional<Client> findById(Class<Client> clientClass, int id);

}
