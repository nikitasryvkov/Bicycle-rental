package com.example.rental.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rental.domain.Bicycle;
import com.example.rental.domain.Payment;
import com.example.rental.domain.enums.BicycleStatus;
import com.example.rental.domain.enums.PaymentStatus;
import com.example.rental.exceptions.CustomPaymentException;
import com.example.rental.repositories.impl.BicycleRepositoryImpl;
import com.example.rental.repositories.impl.PaymentRepositoryImpl;
import com.example.rental.services.PaymentService;

@Service
public class DomainPaymentServiceImpl implements PaymentService {
  @Autowired
  private PaymentRepositoryImpl paymentRepositoryImpl;
  @Autowired
  private BicycleRepositoryImpl bicycleRepositoryImpl;

  @Override
  public void payPayment(int id, BigDecimal money) {

    List<Payment> sortPayment = paymentRepositoryImpl.getAllPayments().stream()
      .filter(s -> s.getPaymentStatus() == PaymentStatus.WAITING)
      .filter(s -> s.getClient().getId() == id)
      .collect(Collectors.toList());

    if (!(sortPayment.get(0).getPrice().compareTo(money) == 0)) {
      int paymentId = sortPayment.get(0).getLeaseAgreement().getBicycle().getId();
      Bicycle bicycle = bicycleRepositoryImpl.findById(Bicycle.class, paymentId);
      bicycle.setBicycleStatus(BicycleStatus.AVAILABLE);
      paymentRepositoryImpl.updateStatus(sortPayment.get(0).getId(), PaymentStatus.CANCELLED);

      throw new CustomPaymentException("Сумма платежа не соответствует прописанной в договоре, повторите алгоритм аренды велосипеда заново");
    }

    paymentRepositoryImpl.updateStatus(sortPayment.get(0).getId(), PaymentStatus.PAID);

  }
}
