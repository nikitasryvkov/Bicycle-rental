package com.example.rental.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.dtos.BicycleDTO;
import com.example.rental.domain.enums.BicycleStatus;
import com.example.rental.domain.enums.BicycleType;
import com.example.rental.dtos.BicycleByFilterDTO;
import com.example.rental.dtos.BicycleDTO;
import com.example.rental.services.impl.BicycleServiceImpl;

@RestController
@RequestMapping("/api/bicycles")
public class BicycleController {

  @Autowired
  public BicycleServiceImpl bicycleServiceImpl;

  @GetMapping("/bicycleByAnth")
  public List<BicycleDTO> getBicycleByAnthropometric(@RequestParam(name = "id") int id) {
    return bicycleServiceImpl.getBicycleByAnthropometricByClient(id);
  }

  @GetMapping("/bicycleByFilter")
  public List<BicycleByFilterDTO> getBicycleByFilter(
      @RequestParam(name = "manufacturer", required = false) String manufacturer,
      @RequestParam(name = "model", required = false) String model,
      @RequestParam(name = "bicycleType", required = false) BicycleType bicycleType,
      @RequestParam(name = "brakesType", required = false) String brakesType,
      @RequestParam(name = "costPerDay", required = false) BigDecimal costPerDay) {

    BicycleByFilterDTO bicycleByFilterDTO = new BicycleByFilterDTO(manufacturer, model, bicycleType, brakesType, costPerDay);
    return bicycleServiceImpl.getBicycleByFilter(bicycleByFilterDTO);
  }

  @PostMapping("/add")
  public BicycleDTO createBicycle(
    @RequestParam(name = "manufacturer") String manufacturer,
    @RequestParam(name = "model") String model,
    @RequestParam(name = "type") BicycleType bicycleType,
    @RequestParam(name = "numberOfSpeeds") int numberOfSpeeds,
    @RequestParam(name = "maxHeight") int maxHeight,
    @RequestParam(name = "maxWeight") int maxWeight,
    @RequestParam(name = "brakesType") String brakesType,
    @RequestParam(name = "costPerDay") BigDecimal costPerDay,
    @RequestParam(name = "bicycleStatus") BicycleStatus bicycleStatus) {

    BicycleDTO bicycleDTO = new BicycleDTO(manufacturer, model, bicycleType, numberOfSpeeds, maxHeight, maxWeight, brakesType, costPerDay, bicycleStatus);
    return bicycleServiceImpl.addBicycle(bicycleDTO);
  }
}
