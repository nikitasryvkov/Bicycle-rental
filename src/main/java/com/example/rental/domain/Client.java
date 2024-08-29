package com.example.rental.domain;

import java.util.List;

import com.example.rental.domain.enums.GenderType;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {
  private String firstName;
  private String lastName;
  private String middleName;
  private GenderType genderType;
  private int height;
  private int weight;
  private String phoneNumber;
  private ProofOfIdentity proofOfIdentity;
  private List<Payment> payments;
  private List<LeaseAgreement> leaseAgreements;

  public Client(String firstName, String lastName, String middleName, GenderType genderType, int height, int weight, String phoneNumber, ProofOfIdentity proofOfIdentity) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.genderType = genderType;
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
  public GenderType getGenderType() {
    return genderType;
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

  @OneToOne(optional = false)
  @JoinColumn(name = "proof_of_identity_id", nullable = false)
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
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public void setGenderType(GenderType genderType) {
    this.genderType = genderType;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setProofOfIdentity(ProofOfIdentity proofOfIdentity) {
    this.proofOfIdentity = proofOfIdentity;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  public void setLeaseAgreements(List<LeaseAgreement> leaseAgreements) {
    this.leaseAgreements = leaseAgreements;
  }

}
