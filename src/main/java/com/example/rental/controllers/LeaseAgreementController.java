package com.example.rental.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.dtos.LeaseAgreementDTO;
import com.example.rental.services.LeaseAgreementService;

@RestController
@RequestMapping("/api/leaseAgreements")
public class LeaseAgreementController {

  @Autowired
  private LeaseAgreementService leaseAgreementService;

  @GetMapping("/bicycleRentalTime")
  public int getFinalRentalTime(@RequestParam(name = "bicycle") int id, @RequestParam(name = "money") BigDecimal money) {
    return leaseAgreementService.getRentalTime(id, money);
  }

  @PostMapping("/rent")
  public LeaseAgreementDTO rentBicycle(@RequestBody LeaseAgreementDTO leaseAgreementDTO) {
    return leaseAgreementService.rentBicycle(leaseAgreementDTO);
  }
}
