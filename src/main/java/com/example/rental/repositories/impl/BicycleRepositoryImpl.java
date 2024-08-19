package com.example.rental.repositories.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.rental.domain.Bicycle;
import com.example.rental.domain.enums.BicycleType;
import com.example.rental.repositories.BicycleRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class BicycleRepositoryImpl extends CRUDRepository<Bicycle, Integer> implements BicycleRepository  {

  @PersistenceContext
  private EntityManager entityManager;

  public BicycleRepositoryImpl(Class<Bicycle> entityClass) {
    super(entityClass);
}

  @Override
  public List<Bicycle> getAvailableBicycleByStatus(boolean isAvailable) {
    return entityManager.createQuery("SELECT b FROM Bicycle b WHERE b.available = :isAvailable", Bicycle.class)
      .setParameter("isAvailable", isAvailable)
      .getResultList();
  }

  @Override
  public List<Bicycle> getAllBicycles() {
    return entityManager.createQuery("SELECT b FROM Bicycle", Bicycle.class).getResultList();
  }

  @Override
  public List<Bicycle> getBicycleByFilter(String manufacturer, String model, String type, String brakesType, BigDecimal costPerDay) {
    return entityManager.createQuery("SELECT b FROM Bicycle b WHERE" +
        "(:manufacturer is null OR b.manufacturer=:manufacturer)" +
        "AND (:model is null OR b.model=:model)" +
        "AND (:type is null OR b.type=:type)" +
        "AND (:brakesType is null OR b.brakesType=:brakesType)" +
        "AND (:costPerDay is null OR b.costPerDay=:costPerDay) order by b.id asc", Bicycle.class)
      .setParameter("manufacturer", manufacturer)
      .setParameter("model", model)
      .setParameter("type", type)
      .setParameter("brakesType", brakesType)
      .setParameter("costPerDay", costPerDay)
      .getResultList();
  }

  @Override
  public void updateStatus(int id, BicycleType bicycleType) {
    entityManager.createQuery("UPDATE Bicycle b SET b.paymentStatus = :paymentStatus WHERE p.id = :id")
      .setParameter("paymentStatus", bicycleType)
      .setParameter("id", id)
      .executeUpdate();
  }

}
