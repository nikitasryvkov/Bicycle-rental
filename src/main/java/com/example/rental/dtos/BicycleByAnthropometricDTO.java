package com.example.rental.dtos;

public class BicycleByAnthropometricDTO extends IdDTO {
  private String manufacturer;
  private String model;
  private String type;
  private int numberOfSpeeds;
  private int maxHeight;
  private int maxWeight;
  private String brakesType;
  private int costPerDay;
  private boolean isAvailable;

  public BicycleByAnthropometricDTO(String manufacturer, String model, String type, int numberOfSpeeds, int maxHeight, int maxWeight, String brakesType, int costPerDay, boolean isAvailable) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.type = type;
    this.numberOfSpeeds = numberOfSpeeds;
    this.maxHeight = maxHeight;
    this.maxWeight = maxWeight;
    this.brakesType = brakesType;
    this.costPerDay = costPerDay;
    this.isAvailable = true;
  }

  protected BicycleByAnthropometricDTO() {}

  public String getManufacturer() {
    return manufacturer;
  }

  public String getModel() {
    return model;
  }

  public String getType() {
    return type;
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

  public int getCostPerDay() {
    return costPerDay;
  }

  public boolean isAvailable() {
    return isAvailable;
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

  public void setCostPerDay(int costPerDay) {
    this.costPerDay = costPerDay;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }
}
