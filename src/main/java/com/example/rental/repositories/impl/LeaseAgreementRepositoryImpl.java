package com.example.rental.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.rental.domain.LeaseAgreement;
import com.example.rental.repositories.LeaseAgreementRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LeaseAgreementRepositoryImpl extends CRUDRepository<LeaseAgreement, Integer> implements LeaseAgreementRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public LeaseAgreementRepositoryImpl(Class<LeaseAgreement> entityClass) {
    super(entityClass);
  }

  @Override
  public List<LeaseAgreement> getLeaseAgreementByClient(int id) {
    return entityManager.createQuery("SELECT l FROM LeaseAgreement l WHERE l.clientId = :id", LeaseAgreement.class)
      .setParameter("id", id)
      .getResultList();
  }

}
