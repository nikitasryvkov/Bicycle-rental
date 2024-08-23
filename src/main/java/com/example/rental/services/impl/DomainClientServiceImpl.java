package com.example.rental.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rental.domain.Client;
import com.example.rental.domain.ProofOfIdentity;
import com.example.rental.domain.enums.ProofOfIdentityStatus;
import com.example.rental.dtos.ClientDTO;
import com.example.rental.dtos.ProofOfIdentityDTO;
import com.example.rental.repositories.impl.ClientRepositoryImpl;
import com.example.rental.repositories.impl.ProofOfIdentityRepositoryImpl;
import com.example.rental.services.ClientService;

@Service
public class DomainClientServiceImpl implements ClientService {
  @Autowired
  private ClientRepositoryImpl clientRepositoryImpl;
  @Autowired
  private ProofOfIdentityRepositoryImpl proofOfIdentityRepositotyImpl;
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public ClientDTO addClient(ClientDTO clientDTO, ProofOfIdentityDTO proofOfIdentityDTO) {
    ProofOfIdentity proofOfIdentity = new ProofOfIdentity(
      proofOfIdentityDTO.getDocumentType(),
      proofOfIdentityDTO.getNumberAndSeries(),
      ProofOfIdentityStatus.CONFIRMATION);

    proofOfIdentityRepositotyImpl.save(proofOfIdentity);

    Client client = new Client(
      clientDTO.getFirstName(),
      clientDTO.getLastName(),
      clientDTO.getMiddleName(),
      clientDTO.getGenderType(),
      clientDTO.getHeight(),
      clientDTO.getWeight(),
      clientDTO.getPhoneNumber(),
      proofOfIdentity);


    clientRepositoryImpl.save(client);

    ClientDTO clientDTO2 = modelMapper.map(client, ClientDTO.class);

    return clientDTO2;
  }
}
