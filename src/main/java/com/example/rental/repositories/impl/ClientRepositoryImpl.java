package com.example.rental.repositories.impl;

import org.springframework.stereotype.Repository;

import com.example.rental.domain.Client;
import com.example.rental.repositories.ClientRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClientRepositoryImpl extends CRUDRepository<Client> implements ClientRepository {

  @PersistenceContext
  private EntityManager entityManager;

}
