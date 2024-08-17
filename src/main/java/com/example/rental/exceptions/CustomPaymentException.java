package com.example.rental.exceptions;

public class CustomPaymentException extends RuntimeException {
  public CustomPaymentException(String massage) {
    super(massage);
  }
}
