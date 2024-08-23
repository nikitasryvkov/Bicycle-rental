package com.example.rental.repositories.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.rental.domain.ProofOfIdentity;
import com.example.rental.domain.enums.PaymentStatus;
import com.example.rental.domain.enums.ProofOfIdentityStatus;
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

  @Override
  @Transactional
  public void updateStatus(int id, ProofOfIdentityStatus proofOfIdentityStatus) {
    entityManager.createQuery("UPDATE ProofOfIdentity p SET p.proofOfIdentityStatus = :proofOfIdentityStatus WHERE p.id = :id")
      .setParameter("proofOfIdentityStatus", proofOfIdentityStatus)
      .setParameter("id", id)
      .executeUpdate();
  }

}
