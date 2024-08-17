package com.example.rental.repositories;

import java.math.BigDecimal;
import java.util.List;

import com.example.rental.domain.Bicycle;
import com.example.rental.domain.enums.BicycleType;

public interface BicycleRepository {

  List<Bicycle> getAvailableBicycleByStatus(boolean isAvailable);
  List<Bicycle> getAllBicycles();
  List<Bicycle> getBicycleByFilter(String manufacturer, String model, String type, String brakesType, BigDecimal costPerDay);
  void updateStatus(int id, BicycleType bicycleType);

}
