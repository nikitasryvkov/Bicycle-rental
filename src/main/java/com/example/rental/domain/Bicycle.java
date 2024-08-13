package com.example.rental.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "bicycles")
public class Bicycle extends BaseEntity {
  private String manufacturer;
  private String model;
  private String type;
  private int numberOfSpeeds;
  private String brakesType;
  private int costPerDay;
  private boolean isAvailable;
  private List<LeaseAgreement> leaseAgreements;

  public Bicycle(String manufacturer, String model, String type, int numberOfSpeeds, String brakesType, int costPerDay, boolean isAvailable, List<LeaseAgreement> leaseAgreements) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.type = type;
    this.numberOfSpeeds = numberOfSpeeds;
    this.brakesType = brakesType;
    this.costPerDay = costPerDay;
    this.isAvailable = true;
    this.leaseAgreements = leaseAgreements;
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
  public String getType() {
    return type;
  }

  @Column(name = "number_of_speeds", nullable = false)
  public int getNumberOfSpeeds() {
    return numberOfSpeeds;
  }

  @Column(name = "brakes_type", length = 63, nullable = false)
  public String getBrakesType() {
    return brakesType;
  }

  @Column(name = "cost_per_day", nullable = false)
  public int getCostPerDay() {
    return costPerDay;
  }

  @Column(name = "isAvailable")
  public boolean isAvailable() {
    return isAvailable;
  }

  @OneToMany(mappedBy = "bicycle", targetEntity = LeaseAgreement.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<LeaseAgreement> getLeaseAgreements() {
    return leaseAgreements;
  }

  public void setManufacturer(String manufacturer) {
    if (manufacturer == null) {
      return;
    }

    this.manufacturer = manufacturer;
  }

  public void setModel(String model) {
    if (model == null) {
      return;
    }

    this.model = model;
  }

  public void setType(String type) {
    if (type == null) {
      return;
    }

    this.type = type;
  }

  public void setNumberOfSpeeds(int numberOfSpeeds) {
    this.numberOfSpeeds = numberOfSpeeds;
  }

  public void setBrakesType(String brakesType) {
    if (brakesType == null) {
      return;
    }

    this.brakesType = brakesType;
  }

  public void setCostPerDay(int costPerDay) {
    this.costPerDay = costPerDay;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public void setLeaseAgreements(List<LeaseAgreement> leaseAgreements) {
    this.leaseAgreements = leaseAgreements;
  }
}
