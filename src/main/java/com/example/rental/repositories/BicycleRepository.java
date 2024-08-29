package com.example.rental.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.rental.domain.Bicycle;
import com.example.rental.domain.enums.BicycleStatus;
import com.example.rental.domain.enums.BicycleType;

public interface BicycleRepository {

  Bicycle save(Bicycle bicycle);

  Optional<Bicycle> findById(Class<Bicycle> clientClass, int id);
  List<Bicycle> getAvailableBicycleByStatus(BicycleStatus bicycleStatus);
  List<Bicycle> getAllBicycles();
  List<Bicycle> getBicycleByFilter(String manufacturer, String model, BicycleType bicycleType, String brakesType, BigDecimal costPerDay);
  void updateStatus(int id, BicycleStatus bicycleStatus);

}
