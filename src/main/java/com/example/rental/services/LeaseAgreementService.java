package com.example.rental.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.rental.domain.Bicycle;
import com.example.rental.dtos.LeaseAgreementDTO;

public interface LeaseAgreementService {

  int getRentalTime(int id, BigDecimal money);
  BigDecimal calculateTotalCost(Bicycle bicycle, LocalDate startDate, LocalDate finishDate);
  LeaseAgreementDTO rentBicycle(LeaseAgreementDTO leaseAgreementDTO);

}
