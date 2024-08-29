package com.example.rental.repositories;

import com.example.rental.domain.ProofOfIdentity;
import com.example.rental.domain.enums.ProofOfIdentityStatus;

public interface ProofOfIdentityRepository {

  ProofOfIdentity save(ProofOfIdentity proofOfIdentity);
  void updateStatus(int id, ProofOfIdentityStatus proofOfIdentityStatus);

}
