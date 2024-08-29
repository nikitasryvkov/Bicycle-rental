package com.example.rental.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.services.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @PatchMapping("/status")
  public void payPayment(@RequestParam(name = "clientId") int id, @RequestParam(name = "money") BigDecimal money) {
    paymentService.payPayment(id, money);
  }
}
