package com.example.rental.repositories.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.rental.domain.Bicycle;
import com.example.rental.domain.enums.BicycleStatus;
import com.example.rental.domain.enums.BicycleType;
import com.example.rental.repositories.BicycleRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class BicycleRepositoryImpl extends CRUDRepository<Bicycle> implements BicycleRepository  {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Bicycle> getAvailableBicycleByStatus(BicycleStatus bicycleStatus) {
    return entityManager.createQuery("SELECT b FROM Bicycle b WHERE b.bicycleStatus = :bicycleStatus", Bicycle.class)
      .setParameter("bicycleStatus", bicycleStatus)
      .getResultList();
  }

  @Override
  public List<Bicycle> getAllBicycles() {
    return entityManager.createQuery("SELECT b FROM Bicycle", Bicycle.class).getResultList();
  }

  @Override
  public List<Bicycle> getBicycleByFilter(String manufacturer, String model, BicycleType bicycleType, String brakesType, BigDecimal costPerDay) {
    return entityManager.createQuery("SELECT b FROM Bicycle b WHERE" +
        "(:manufacturer is null OR b.manufacturer=:manufacturer)" +
        "AND (:model is null OR b.model=:model)" +
        "AND (:bicycleType is null OR b.bicycleType=:bicycleType)" +
        "AND (:brakesType is null OR b.brakesType=:brakesType)" +
        "AND (:costPerDay is null OR b.costPerDay=:costPerDay) order by b.id asc", Bicycle.class)
      .setParameter("manufacturer", manufacturer)
      .setParameter("model", model)
      .setParameter("bicycleType", bicycleType)
      .setParameter("brakesType", brakesType)
      .setParameter("costPerDay", costPerDay)
      .getResultList();
  }

  @Override
  @Transactional
  public void updateStatus(int id, BicycleStatus bicycleStatus) {
    entityManager.createQuery("UPDATE Bicycle b SET b.bicycleStatus = :bicycleStatus WHERE b.id = :id")
      .setParameter("bicycleStatus", bicycleStatus)
      .setParameter("id", id)
      .executeUpdate();
  }

}
