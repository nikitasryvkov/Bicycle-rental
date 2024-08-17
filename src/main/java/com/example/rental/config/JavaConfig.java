package com.example.rental.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rental.domain.Bicycle;
import com.example.rental.domain.Client;
import com.example.rental.domain.LeaseAgreement;
import com.example.rental.domain.Payment;
import com.example.rental.domain.ProofOfIdentity;
import com.example.rental.dtos.BicycleByAnthropometricDTO;

@Configuration
public class JavaConfig {
  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.createTypeMap(Bicycle.class, BicycleByAnthropometricDTO.class);
    return modelMapper;
  }

  @Bean
  public Class<Bicycle> bicycleClass() {
    return Bicycle.class;
  }

  @Bean
  public Class<Client> clientClass() {
    return Client.class;
  }

  @Bean
  public Class<LeaseAgreement> leaseAgreementClass() {
    return LeaseAgreement.class;
  }

  @Bean
  public Class<Payment> paymentClass() {
    return Payment.class;
  }

  @Bean
  public Class<ProofOfIdentity> proofOfIdentityClass() {
    return ProofOfIdentity.class;
  }
}
