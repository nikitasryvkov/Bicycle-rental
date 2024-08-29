package com.example.rental.repositories.impl;

import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public abstract class CRUDRepository<T> {
  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public T save(T entity) {
    entityManager.persist(entity);
    return entity;
  }

  public Optional<T> findById(Class<T> entityClass, int id) {
    return Optional.ofNullable(entityManager.find(entityClass, id));
  }

  @Transactional
  public T update(T entity) {
    entityManager.merge(entity);
    return entity;
  }
}
