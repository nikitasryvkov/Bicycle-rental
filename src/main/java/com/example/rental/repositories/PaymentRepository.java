package com.example.rental.repositories;

import java.util.List;

import com.example.rental.domain.Payment;
import com.example.rental.domain.enums.PaymentStatus;

public interface PaymentRepository {

  Payment save(Payment payment);
  List<Payment> getAllPayments();
  Payment getPaymentByClient(int id);
  void updateStatus(int id, PaymentStatus paymentStatus);

}
