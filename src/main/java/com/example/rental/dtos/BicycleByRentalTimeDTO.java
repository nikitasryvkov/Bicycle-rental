package com.example.rental.dtos;

import java.math.BigDecimal;

public class BicycleByRentalTimeDTO extends IdDTO {
  private String manufacturer;
  private String model;
  private BigDecimal costPerDay;

  public BicycleByRentalTimeDTO(String manufacturer, String model, BigDecimal costPerDay) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.costPerDay = costPerDay;
  }

  protected BicycleByRentalTimeDTO() {}

  public String getManufacturer() {
    return manufacturer;
  }

  public String getModel() {
    return model;
  }

  public BigDecimal getCostPerDay() {
    return costPerDay;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setCostPerDay(BigDecimal costPerDay) {
    this.costPerDay = costPerDay;
  }
}
