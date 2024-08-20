package com.example.rental.domain;

import com.example.rental.domain.enums.ProofOfIdentityStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "proofOfIdentities")
public class ProofOfIdentity extends BaseEntity {
  private String documentType;
  private String numberAndSeries;
  private Client client;
  private ProofOfIdentityStatus proofOfIdentityStatus;

  public ProofOfIdentity(String documentType, String numberAndSeries, Client client, ProofOfIdentityStatus proofOfIdentityStatus) {
    this.documentType = documentType;
    this.numberAndSeries = numberAndSeries;
    this.client = client;
    this.proofOfIdentityStatus =proofOfIdentityStatus;
  }

  protected ProofOfIdentity() {}

  @Column(name = "document_type", length = 63, nullable = false)
  public String getDocumentType() {
    return documentType;
  }

  @Column(name = "number_and_series", length = 63, nullable = false)
  public String getNumberAndSeries() {
    return numberAndSeries;
  }

  @OneToOne(mappedBy = "proofOfIdentity", targetEntity = Client.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public Client getClient() {
    return client;
  }

  @Column(name = "proof_of_identity_status", nullable = false)
  @Enumerated(EnumType.STRING)
  public ProofOfIdentityStatus getProofOfIdentityStatus() {
    return proofOfIdentityStatus;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public void setNumberAndSeries(String numberAndSeries) {
    this.numberAndSeries = numberAndSeries;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public void setProofOfIdentityStatus(ProofOfIdentityStatus proofOfIdentityStatus) {
    this.proofOfIdentityStatus = proofOfIdentityStatus;
  }
}
