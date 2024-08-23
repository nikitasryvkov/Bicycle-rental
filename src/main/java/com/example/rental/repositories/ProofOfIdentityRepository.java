package com.example.rental.repositories;

import com.example.rental.domain.enums.ProofOfIdentityStatus;

public interface ProofOfIdentityRepository {

  void updateStatus(int id, ProofOfIdentityStatus proofOfIdentityStatus);

}
