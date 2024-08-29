package com.example.rental.repositories;

import java.util.List;

import com.example.rental.domain.LeaseAgreement;

public interface LeaseAgreementRepository {

  LeaseAgreement save(LeaseAgreement leaseAgreement);
  List<LeaseAgreement> getLeaseAgreementByClient(int id);

}
