package com.example.rental.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public abstract class CRUDRepository<DomainEntity, T> {
  private final Class<DomainEntity> entityClass;
  @PersistenceContext
  private EntityManager entityManager;

  public CRUDRepository(Class<DomainEntity> entityClass) {
    this.entityClass = entityClass;
  }

  @Transactional
  public DomainEntity save(DomainEntity domainEntity) {
    entityManager.persist(domainEntity);
    return domainEntity;
  }

  public DomainEntity findById(Class<DomainEntity> entityClass, int id) {
    return entityManager.find(entityClass, id);
  }

  @Transactional
  public DomainEntity update(DomainEntity domainEntity) {
    entityManager.merge(domainEntity);
    return domainEntity;
  }
}
