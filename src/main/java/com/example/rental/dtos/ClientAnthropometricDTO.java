package com.example.rental.dtos;

public class ClientAnthropometricDTO extends IdDTO {
  private String firstName;
  private String lastName;
  private int height;
  private int weight;

  public ClientAnthropometricDTO(String firstName, String lastName, int height, int weight) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.height = height;
    this.weight = weight;
  }

  protected ClientAnthropometricDTO() {}

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getHeight() {
    return height;
  }

  public int getWeight() {
    return weight;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}
