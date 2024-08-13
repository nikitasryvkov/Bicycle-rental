package com.example.rental.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {
  private String firstName;
  private String lastName;
  private String middleName;
  private String gender;
  private int height;
  private int weight;
  private String phoneNumber;
  private ProofOfIdentity proofOfIdentity;
  private List<Payment> payments;
  private List<LeaseAgreement> leaseAgreements;

  public Client(String firstName, String lastName, String middleName, String gender, int height, int weight, String phoneNumber, ProofOfIdentity proofOfIdentity) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.phoneNumber = phoneNumber;
    this.proofOfIdentity = proofOfIdentity;
  }

  protected Client() {}

  @Column(name = "first_name", length = 63, nullable = false)
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", length = 63, nullable = false)
  public String getLastName() {
    return lastName;
  }

  @Column(name = "middle_name", length = 63, nullable = false)
  public String getMiddleName() {
    return middleName;
  }

  @Column(name = "gender", length = 63, nullable = false)
  public String getGender() {
    return gender;
  }

  @Column(name = "height", nullable = false)
  public int getHeight() {
    return height;
  }

  @Column(name = "weight", nullable = false)
  public int getWeight() {
    return weight;
  }

  @Column(name = "phone_number", length = 63, nullable = false)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  @OneToOne(mappedBy = "client", targetEntity = ProofOfIdentity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public ProofOfIdentity getProofOfIdentity() {
    return proofOfIdentity;
  }

  @OneToMany(mappedBy = "client", targetEntity = Payment.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<Payment> getPayments() {
    return payments;
  }

  @OneToMany(mappedBy = "client", targetEntity = LeaseAgreement.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<LeaseAgreement> getLeaseAgreements() {
    return leaseAgreements;
  }

  public void setFirstName(String firstName) {
    if (firstName == null) {
      return;
    }

    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    if (lastName == null) {
      return;
    }

    this.lastName = lastName;
  }

  public void setMiddleName(String middleName) {
    if (middleName == null) {
      return;
    }

    this.middleName = middleName;
  }

  public void setGender(String gender) {
    if (gender == null) {
      return;
    }

    this.gender = gender;
  }

  public void setHeight(int height) {
    if (height <= 0) {
      return;
    }

    this.height = height;
  }

  public void setWeight(int weight) {
    if (weight <= 0) {
      return;
    }

    this.weight = weight;
  }

  public void setPhoneNumber(String phoneNumber) {
    if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
      return;
    }

    this.phoneNumber = phoneNumber;
  }

  public void setProofOfIdentity(ProofOfIdentity proofOfIdentity) {
    if (proofOfIdentity == null) {
      return;
    }

    this.proofOfIdentity = proofOfIdentity;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  public void setLeaseAgreements(List<LeaseAgreement> leaseAgreements) {
    this.leaseAgreements = leaseAgreements;
  }

}
