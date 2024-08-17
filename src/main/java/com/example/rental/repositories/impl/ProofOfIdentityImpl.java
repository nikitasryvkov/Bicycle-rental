package com.example.rental.repositories.impl;

import org.springframework.stereotype.Repository;

import com.example.rental.domain.ProofOfIdentity;
import com.example.rental.repositories.CRUDRepository;
import com.example.rental.repositories.ProofOfIdentityRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProofOfIdentityImpl extends CRUDRepository<ProofOfIdentity, Integer> implements ProofOfIdentityRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public ProofOfIdentityImpl(Class<ProofOfIdentity> entityClass) {
    super(entityClass);
  }

}
