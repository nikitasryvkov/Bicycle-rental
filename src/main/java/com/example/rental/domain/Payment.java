package com.example.rental.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.example.rental.domain.enums.PaymentStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {
  private BigDecimal price;
  private OffsetDateTime dateTime;
  private PaymentStatus paymentStatus;
  private Client client;
  private LeaseAgreement leaseAgreement;

  public Payment(BigDecimal price, OffsetDateTime dateTime, PaymentStatus paymentStatus, Client client) {
    this.price = price;
    this.dateTime = OffsetDateTime.now();
    this.paymentStatus = PaymentStatus.WAITING;
    this.client = client;
  }

  protected Payment() {}

  @Column(name = "price", nullable = false)
  public BigDecimal getPrice() {
    return price;
  }

  @Column(name = "date_time", nullable = false)
  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  @Column(name = "payment_status", nullable = false)
  @Enumerated(EnumType.STRING)
  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  public Client getClient() {
    return client;
  }

  @OneToOne(mappedBy = "payment", targetEntity = LeaseAgreement.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public LeaseAgreement getLeaseAgreement() {
    return leaseAgreement;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public void setLeaseAgreement(LeaseAgreement leaseAgreement) {
    this.leaseAgreement = leaseAgreement;
  }
}
