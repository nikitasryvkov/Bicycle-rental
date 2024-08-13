package com.example.rental.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "proofOfIdentities")
public class ProofOfIdentity extends BaseEntity {
  private String documentType;
  private String numberAndSeries;
  private Client client;

  public ProofOfIdentity(String documentType, String numberAndSeries, Client client) {
    this.documentType = documentType;
    this.numberAndSeries = numberAndSeries;
    this.client = client;
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

  @OneToOne(optional = false)
  @JoinColumn(name = "client_id", nullable = false)
  public Client getClient() {
    return client;
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
}
