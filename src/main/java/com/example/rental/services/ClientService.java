package com.example.rental.services;

import com.example.rental.dtos.ClientDTO;
import com.example.rental.dtos.ProofOfIdentityDTO;

public interface ClientService {

  ClientDTO addClient(ClientDTO clientDTO, ProofOfIdentityDTO proofOfIdentityDTO);

}
