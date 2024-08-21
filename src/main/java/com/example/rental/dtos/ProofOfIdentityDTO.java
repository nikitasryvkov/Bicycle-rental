package com.example.rental.dtos;

public class ProofOfIdentityDTO extends IdDTO {
  private String documentType;
  private String numberAndSeries;

  public ProofOfIdentityDTO(String documentType, String numberAndSeries) {
    this.documentType = documentType;
    this.numberAndSeries = numberAndSeries;
  }

  protected ProofOfIdentityDTO() {}

  public String getDocumentType() {
    return documentType;
  }

  public String getNumberAndSeries() {
    return numberAndSeries;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public void setNumberAndSeries(String numberAndSeries) {
    this.numberAndSeries = numberAndSeries;
  }
}
