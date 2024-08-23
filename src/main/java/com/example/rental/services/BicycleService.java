package com.example.rental.services;

import java.util.List;

import com.example.rental.dtos.BicycleDTO;
import com.example.rental.dtos.BicycleByFilterDTO;

public interface BicycleService {

  BicycleDTO addBicycle(BicycleDTO bicycleDTO);
  List<BicycleDTO> getBicycleByAnthropometricByClient(int id);
  List<BicycleByFilterDTO> getBicycleByFilter(BicycleByFilterDTO bicycleByFilterDTO);

}
