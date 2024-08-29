package com.example.rental.domain;

import java.math.BigDecimal;
import java.util.List;

import com.example.rental.domain.enums.BicycleStatus;
import com.example.rental.domain.enums.BicycleType;

import jakarta.persistence.*;

@Entity
@Table(name = "bicycles")
public class Bicycle extends BaseEntity {
  private String manufacturer;
  private String model;
  private BicycleType bicycleType;
  private int numberOfSpeeds;
  private int maxHeight;
  private int maxWeight;
  private String brakesType;
  private BigDecimal costPerDay;
  private BicycleStatus bicycleStatus;
  private List<LeaseAgreement> leaseAgreements;

  public Bicycle(String manufacturer, String model, BicycleType bicycleType, int numberOfSpeeds, int maxHeight, int maxWeight, String brakesType, BigDecimal costPerDay, BicycleStatus bicycleStatus) {
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

  protected Bicycle() {}

  @Column(name = "manufacturer", length = 63, nullable = false)
  public String getManufacturer() {
    return manufacturer;
  }

  @Column(name = "model", length = 63, nullable = false)
  public String getModel() {
    return model;
  }

  @Column(name = "type", length = 63, nullable = false)
  @Enumerated(EnumType.STRING)
  public BicycleType getBicycleType() {
    return bicycleType;
  }

  @Column(name = "number_of_speeds", nullable = false)
  public int getNumberOfSpeeds() {
    return numberOfSpeeds;
  }

  @Column(name = "max_height", nullable = false)
  public int getMaxHeight() {
    return maxHeight;
  }

  @Column(name = "max_weight", nullable = false)
  public int getMaxWeight() {
    return maxWeight;
  }

  @Column(name = "brakes_type", length = 63)
  public String getBrakesType() {
    return brakesType;
  }

  @Column(name = "cost_per_day")
  public BigDecimal getCostPerDay() {
    return costPerDay;
  }

  @Column(name = "bicycle_status")
  @Enumerated(EnumType.STRING)
  public BicycleStatus getBicycleStatus() {
    return bicycleStatus;
  }

  @OneToMany(mappedBy = "bicycle", targetEntity = LeaseAgreement.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<LeaseAgreement> getLeaseAgreements() {
    return leaseAgreements;
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

  public void setLeaseAgreements(List<LeaseAgreement> leaseAgreements) {
    this.leaseAgreements = leaseAgreements;
  }
}
