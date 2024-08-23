package com.example.rental.dtos;

import java.math.BigDecimal;

import com.example.rental.domain.enums.BicycleStatus;
import com.example.rental.domain.enums.BicycleType;

public class BicycleDTO extends IdDTO {
  private String manufacturer;
  private String model;
  private BicycleType bicycleType;
  private int numberOfSpeeds;
  private int maxHeight;
  private int maxWeight;
  private String brakesType;
  private BigDecimal costPerDay;
  private BicycleStatus bicycleStatus;

  public BicycleDTO(String manufacturer, String model, BicycleType bicycleType, int numberOfSpeeds, int maxHeight, int maxWeight, String brakesType, BigDecimal costPerDay, BicycleStatus bicycleStatus) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.bicycleType = bicycleType;
    this.numberOfSpeeds = numberOfSpeeds;
    this.maxHeight = maxHeight;
    this.maxWeight = maxWeight;
    this.brakesType = brakesType;
    this.costPerDay = costPerDay;
    this.bicycleStatus = bicycleStatus;
  }

  protected BicycleDTO() {}

  public String getManufacturer() {
    return manufacturer;
  }

  public String getModel() {
    return model;
  }

  public BicycleType getBicycleType() {
    return bicycleType;
  }

  public int getNumberOfSpeeds() {
    return numberOfSpeeds;
  }

  public int getMaxHeight() {
    return maxHeight;
  }

  public int getMaxWeight() {
    return maxWeight;
  }

  public String getBrakesType() {
    return brakesType;
  }

  public BigDecimal getCostPerDay() {
    return costPerDay;
  }

  public BicycleStatus getBicycleStatus() {
    return bicycleStatus;
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

  public void setNumberOfSpeeds(int numberOfSpeeds) {
    this.numberOfSpeeds = numberOfSpeeds;
  }

  public void setMaxHeight(int maxHeight) {
    this.maxHeight = maxHeight;
  }

  public void setMaxWeight(int maxWeight) {
    this.maxWeight = maxWeight;
  }

  public void setBrakesType(String brakesType) {
    this.brakesType = brakesType;
  }

  public void setCostPerDay(BigDecimal costPerDay) {
    this.costPerDay = costPerDay;
  }

  public void setBicycleStatus(BicycleStatus bicycleStatus) {
    this.bicycleStatus = bicycleStatus;
  }
}
