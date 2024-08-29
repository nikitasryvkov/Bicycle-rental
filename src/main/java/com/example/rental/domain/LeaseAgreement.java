package com.example.rental.domain;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "leaseAgreements")
public class LeaseAgreement extends BaseEntity {
  private LocalDate startDate;
  private LocalDate finishDate;
  private Client client;
  private Bicycle bicycle;
  private Payment payment;

  public LeaseAgreement(LocalDate startDate, LocalDate finishDate, Client client, Bicycle bicycle, Payment payment) {
    this.startDate = startDate;
    this.finishDate = finishDate;
    this.client = client;
    this.bicycle = bicycle;
    this.payment = payment;
  }

  protected LeaseAgreement() {}

  @Column(name = "start_date", nullable = false)
  public LocalDate getStartDate() {
    return startDate;
  }

  @Column(name = "finish_date", nullable = false)
  public LocalDate getFinishDate() {
    return finishDate;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "client_id", nullable = false)
  public Client getClient() {
    return client;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "bicycle_id", nullable = false)
  public Bicycle getBicycle() {
    return bicycle;
  }

  @OneToOne(optional = false)
  @JoinColumn(name = "payment_id", nullable = false)
  public Payment getPayment() {
    return payment;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public void setFinishDate(LocalDate finishDate) {
    this.finishDate = finishDate;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public void setBicycle(Bicycle bicycle) {
    this.bicycle = bicycle;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }
}
