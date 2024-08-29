package com.example.rental.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rental.domain.Bicycle;
import com.example.rental.domain.Client;
import com.example.rental.domain.LeaseAgreement;
import com.example.rental.domain.Payment;
import com.example.rental.domain.ProofOfIdentity;
import com.example.rental.domain.enums.BicycleStatus;
import com.example.rental.domain.enums.PaymentStatus;
import com.example.rental.dtos.BicycleByRentalTimeDTO;
import com.example.rental.dtos.LeaseAgreementDTO;
import com.example.rental.exceptions.CustomPaymentException;
import com.example.rental.exceptions.CustomProofOfIdentityException;
import com.example.rental.exceptions.NoAvailableBicyclesException;
import com.example.rental.repositories.BicycleRepository;
import com.example.rental.repositories.ClientRepository;
import com.example.rental.repositories.LeaseAgreementRepository;
import com.example.rental.repositories.PaymentRepository;
import com.example.rental.services.LeaseAgreementService;

@Service
public class DomainLeaseAgreementServiceImpl implements LeaseAgreementService {
  @Autowired
  private LeaseAgreementRepository leaseAgreementRepository;
  @Autowired
  private BicycleRepository bicycleRepository;
  @Autowired
  private ClientRepository clientRepository;
  @Autowired
  private PaymentRepository paymentRepository;
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public int getRentalTime(int id, BigDecimal money) {
    Bicycle bicycle = bicycleRepository.findById(Bicycle.class, id).get();
    BicycleByRentalTimeDTO bicycleByRentalTimeDTO = modelMapper.map(bicycle, BicycleByRentalTimeDTO.class);

    int numberOfDays = money.divide(bicycleByRentalTimeDTO.getCostPerDay(), 0, RoundingMode.DOWN).intValue();

    return numberOfDays;
  }

  @Override
  public BigDecimal calculateTotalCost(Bicycle bicycle, LocalDate startDate, LocalDate finishDate) {
    long days = startDate.until(finishDate, ChronoUnit.DAYS);
    BigDecimal costPerDay = bicycleRepository.findById(Bicycle.class, bicycle.getId()).get().getCostPerDay();
    BigDecimal rentalAmount = costPerDay.multiply(BigDecimal.valueOf(days));

    return rentalAmount;
  }

  @Override
  public LeaseAgreementDTO rentBicycle(LeaseAgreementDTO leaseAgreementDTO) {
    LocalDate startDate = leaseAgreementDTO.getStartDate();
    LocalDate finishDate = leaseAgreementDTO.getFinishDate();
    Integer clientId = leaseAgreementDTO.getClientId();
    Integer bicycleId = leaseAgreementDTO.getBicycleId();

    Client client = clientRepository.findById(Client.class, clientId).get();
    Bicycle bicycle = bicycleRepository.findById(Bicycle.class, bicycleId).get();
    ProofOfIdentity proofOfIdentity = client.getProofOfIdentity();

    List<Payment> sortPayment = paymentRepository.getAllPayments().stream()
      .filter(s -> s.getPaymentStatus() == PaymentStatus.WAITING)
      .collect(Collectors.toList());

    if (proofOfIdentity.getProofOfIdentityStatus().toString() == "CONFIRMATION") {
      throw new CustomProofOfIdentityException("Необходимо подтвердить документ");
    }

    if (!sortPayment.isEmpty()) {
      throw new CustomPaymentException("У данного клиента есть не оплаченный платеж");
    }

    if (bicycle.getBicycleStatus().toString() == "RESERVED") {
      throw new NoAvailableBicyclesException("Выбранный велосипед уже арендован");
    } else {
      bicycleRepository.updateStatus(bicycleId, BicycleStatus.RESERVED);
    }

    Payment payment = new Payment(calculateTotalCost(bicycle, startDate, finishDate), OffsetDateTime.now(), PaymentStatus.WAITING, client);
    paymentRepository.save(payment);

    LeaseAgreement leaseAgreement = new LeaseAgreement(startDate, finishDate, client, bicycle, payment);
    leaseAgreementRepository.save(leaseAgreement);

    LeaseAgreementDTO finalLeaseAgreement = modelMapper.map(leaseAgreement, LeaseAgreementDTO.class);

    return finalLeaseAgreement;
  }
}
