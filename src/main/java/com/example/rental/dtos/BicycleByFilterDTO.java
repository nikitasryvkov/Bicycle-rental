package com.example.rental.dtos;

import java.math.BigDecimal;

import com.example.rental.domain.enums.BicycleType;

public class BicycleByFilterDTO extends IdDTO {
  private String manufacturer;
  private String model;
  private BicycleType bicycleType;
  private String brakesType;
  private BigDecimal costPerDay;

  public BicycleByFilterDTO(String manufacturer, String model, BicycleType bicycleType, String brakesType, BigDecimal costPerDay) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.bicycleType = bicycleType;
    this.brakesType = brakesType;
    this.costPerDay = costPerDay;
  }

  protected BicycleByFilterDTO() {}

  public String getManufacturer() {
    return manufacturer;
  }

  public String getModel() {
    return model;
  }

  public BicycleType getBicycleType() {
    return bicycleType;
  }

  public String getBrakesType() {
    return brakesType;
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

  public void setBicycleType(BicycleType bicycleType) {
    this.bicycleType = bicycleType;
  }

  public void setBrakesType(String brakesType) {
    this.brakesType = brakesType;
  }

  public void setCostPerDay(BigDecimal costPerDay) {
    this.costPerDay = costPerDay;
  }
}
