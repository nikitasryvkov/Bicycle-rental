package com.example.rental.domain;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {
  private int id;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  protected void setId(int id) {
    this.id = id;
  }
}
