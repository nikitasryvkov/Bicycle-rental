package com.example.rental.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.rental.domain.Payment;
import com.example.rental.domain.enums.PaymentStatus;
import com.example.rental.repositories.CRUDRepository;
import com.example.rental.repositories.PaymentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PaymentRepositoryImpl extends CRUDRepository<Payment, Integer> implements PaymentRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public PaymentRepositoryImpl(Class<Payment> entityClass) {
    super(entityClass);
  }

  @Override
  public List<Payment> getAllPayments() {
    return entityManager.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
  }

  @Override
  public Payment getPaymentByClient(int id) {
    return entityManager.createQuery("SELECT p FROM Payment p WHERE p.client_id = :id", Payment.class)
      .setParameter("id", id).getSingleResult();
  }

  @Override
  @Transactional
  public void updateStatus(int id, PaymentStatus paymentStatus) {
    entityManager.createQuery("UPDATE Payment p SET p.paymentStatus = :paymentStatus WHERE p.id = :id")
      .setParameter("paymentStatus", paymentStatus)
      .setParameter("id", id)
      .executeUpdate();
  }
}
