package com.example.rental.dtos;

import java.time.LocalDate;

public class LeaseAgreementDTO extends IdDTO {
  private LocalDate startDate;
  private LocalDate finishDate;
  private Integer clientId;
  private Integer bicycleId;

  public LeaseAgreementDTO(LocalDate startDate, LocalDate finishDate, Integer clientId, Integer bicycleId) {
    this.startDate = startDate;
    this.finishDate = finishDate;
    this.clientId = clientId;
    this.bicycleId = bicycleId;
  }

  protected LeaseAgreementDTO() {}

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getFinishDate() {
    return finishDate;
  }

  public Integer getClientId() {
    return clientId;
  }

  public Integer getBicycleId() {
    return bicycleId;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public void setFinishDate(LocalDate finishDate) {
    this.finishDate = finishDate;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public void setBicycleId(Integer bicycleId) {
    this.bicycleId = bicycleId;
  }
}
