package com.example.rental.services.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rental.domain.Client;
import com.example.rental.domain.enums.ProofOfIdentityStatus;
import com.example.rental.exceptions.CustomProofOfIdentityException;
import com.example.rental.repositories.impl.ClientRepositoryImpl;
import com.example.rental.repositories.impl.ProofOfIdentityRepositoryImpl;
import com.example.rental.services.ProofOfIdentityService;

@Service
public class ProofOfIdentityServiceImpl implements ProofOfIdentityService{
  @Autowired
  private ProofOfIdentityRepositoryImpl proofOfIdentityRepositoryImpl;
  @Autowired
  private ClientRepositoryImpl clientRepositoryImpl;

  @Override
  public void verificationProofOfIdentity(int id, LocalDate localDate) {
    long years = ChronoUnit.YEARS.between(localDate, localDate.now());

    if(years < 14) {
      throw new CustomProofOfIdentityException("Возраст не соответствует минимальному порогу");
    }

    Client client = clientRepositoryImpl.findById(Client.class, id);
    proofOfIdentityRepositoryImpl.updateStatus(client.getProofOfIdentity().getId(), ProofOfIdentityStatus.VERIFIED);
  }

}
