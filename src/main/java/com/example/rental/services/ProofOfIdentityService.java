package com.example.rental.services;

import java.time.LocalDate;

public interface ProofOfIdentityService {

  void verificationProofOfIdentity(int id, LocalDate localDate);

}
