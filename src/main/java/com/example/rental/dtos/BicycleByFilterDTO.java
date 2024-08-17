package com.example.rental.dtos;

import java.math.BigDecimal;

public class BicycleByFilterDTO extends IdDTO {
  private String manufacturer;
  private String model;
  private String type;
  private String brakesType;
  private BigDecimal costPerDay;

  public BicycleByFilterDTO(String manufacturer, String model, String type, String brakesType, BigDecimal costPerDay) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.type = type;
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

  public String getType() {
    return type;
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

  public void setType(String type) {
    this.type = type;
  }

  public void setBrakesType(String brakesType) {
    this.brakesType = brakesType;
  }

  public void setCostPerDay(BigDecimal costPerDay) {
    this.costPerDay = costPerDay;
  }
}
