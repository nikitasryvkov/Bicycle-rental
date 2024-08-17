package com.example.rental.services;

import java.util.List;

import com.example.rental.dtos.BicycleByAnthropometricDTO;
import com.example.rental.dtos.BicycleByFilterDTO;

public interface BicycleService {

  List<BicycleByAnthropometricDTO> getBicycleByAnthropometricByClient(int id);
  List<BicycleByFilterDTO> getBicycleByFilter(BicycleByFilterDTO bicycleByFilterDTO);

}
