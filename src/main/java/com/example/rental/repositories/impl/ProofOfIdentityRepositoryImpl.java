package com.example.rental.repositories.impl;

import org.springframework.stereotype.Repository;

import com.example.rental.domain.ProofOfIdentity;
import com.example.rental.repositories.ProofOfIdentityRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProofOfIdentityRepositoryImpl extends CRUDRepository<ProofOfIdentity, Integer> implements ProofOfIdentityRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public ProofOfIdentityRepositoryImpl(Class<ProofOfIdentity> entityClass) {
    super(entityClass);
  }

}
