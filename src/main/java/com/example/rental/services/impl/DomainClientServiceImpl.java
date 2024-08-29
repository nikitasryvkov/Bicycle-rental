package com.example.rental.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rental.domain.Client;
import com.example.rental.domain.ProofOfIdentity;
import com.example.rental.domain.enums.ProofOfIdentityStatus;
import com.example.rental.dtos.ClientDTO;
import com.example.rental.dtos.ProofOfIdentityDTO;
import com.example.rental.repositories.ClientRepository;
import com.example.rental.repositories.ProofOfIdentityRepository;
import com.example.rental.services.ClientService;

@Service
public class DomainClientServiceImpl implements ClientService {
  @Autowired
  private ClientRepository clientRepository;
  @Autowired
  private ProofOfIdentityRepository proofOfIdentityRepository;
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public ClientDTO addClient(ClientDTO clientDTO, ProofOfIdentityDTO proofOfIdentityDTO) {
    ProofOfIdentity proofOfIdentity = new ProofOfIdentity(
      proofOfIdentityDTO.getDocumentType(),
      proofOfIdentityDTO.getNumberAndSeries(),
      ProofOfIdentityStatus.CONFIRMATION);

    proofOfIdentityRepository.save(proofOfIdentity);

    Client client = new Client(
      clientDTO.getFirstName(),
      clientDTO.getLastName(),
      clientDTO.getMiddleName(),
      clientDTO.getGenderType(),
      clientDTO.getHeight(),
      clientDTO.getWeight(),
      clientDTO.getPhoneNumber(),
      proofOfIdentity);


    clientRepository.save(client);

    ClientDTO clientAdd = modelMapper.map(client, ClientDTO.class);

    return clientAdd;
  }
}
