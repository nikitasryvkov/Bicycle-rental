package com.example.rental.dtos;

public class ClientDTO extends IdDTO {
  private String firstName;
  private String lastName;
  private String middleName;
  private String gender;
  private int height;
  private int weight;
  private String phoneNumber;

  public ClientDTO(String firstName, String lastName, String middleName, String gender, int height, int weight, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.gender = gender;
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

  public String getGender() {
    return gender;
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

  public void setGender(String gender) {
    this.gender = gender;
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
