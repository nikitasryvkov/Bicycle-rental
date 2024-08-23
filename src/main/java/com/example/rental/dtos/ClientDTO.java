package com.example.rental.dtos;

import com.example.rental.domain.enums.GenderType;

public class ClientDTO extends IdDTO {
  private String firstName;
  private String lastName;
  private String middleName;
  private GenderType genderType;
  private int height;
  private int weight;
  private String phoneNumber;

  public ClientDTO(String firstName, String lastName, String middleName, GenderType genderType, int height, int weight, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.genderType = genderType;
    this.height = height;
    this.weight = weight;
    this.phoneNumber = phoneNumber;
  }

  protected ClientDTO() {}

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public GenderType getGenderType() {
    return genderType;
  }

  public int getHeight() {
    return height;
  }

  public int getWeight() {
    return weight;
  }

  public String getPhoneNumber() {
    return phoneNumber;
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
}
