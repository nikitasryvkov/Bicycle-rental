package com.example.rental.services;

import java.math.BigDecimal;

public interface PaymentService {

  void payPayment(int id, BigDecimal money);

}
