package com.example.rental.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.dtos.BicycleByAnthropometricDTO;
import com.example.rental.dtos.BicycleByFilterDTO;
import com.example.rental.services.impl.BicycleServiceImpl;

@RestController
@RequestMapping("/api/bicycles")
public class BicycleController {

  @Autowired
  public BicycleServiceImpl bicycleServiceImpl;

  @GetMapping("/bicycleByAnth")
  public List<BicycleByAnthropometricDTO> getBicycleByAnthropometric(@RequestParam(name = "id") int id) {
    return bicycleServiceImpl.getBicycleByAnthropometricByClient(id);
  }

  @GetMapping("/bicycleByFilter")
  public List<BicycleByFilterDTO> getBicycleByFilter(
      @RequestParam(name = "manufacturer", required = false) String manufacturer,
      @RequestParam(name = "model", required = false) String model,
      @RequestParam(name = "type", required = false) String type,
      @RequestParam(name = "brakesType", required = false) String brakesType,
      @RequestParam(name = "costPerDay", required = false) BigDecimal costPerDay) {

    BicycleByFilterDTO bicycleByFilterDTO = new BicycleByFilterDTO(manufacturer, model, type, brakesType, costPerDay);
    return bicycleServiceImpl.getBicycleByFilter(bicycleByFilterDTO);
  }
}
