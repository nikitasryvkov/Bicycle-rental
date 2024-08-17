package com.example.rental.exceptions;

public class NoAvailableBicyclesException extends RuntimeException {
  public NoAvailableBicyclesException(String message) {
    super(message);
  }
}
