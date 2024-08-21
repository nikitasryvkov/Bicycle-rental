package com.example.rental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.dtos.ClientDTO;
import com.example.rental.dtos.ProofOfIdentityDTO;
import com.example.rental.services.impl.DomainClientServiceImpl;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

  @Autowired
  public DomainClientServiceImpl domainClientServiceImpl;

  @PostMapping()
  public ClientDTO create(
    @RequestParam(name = "firstName") String firstName,
    @RequestParam(name = "lastName") String lastName,
    @RequestParam(name = "middleName") String middleName,
    @RequestParam(name = "gender") String gender,
    @RequestParam(name = "height") int height,
    @RequestParam(name = "weight") int weight,
    @RequestParam(name = "phoneNumber") String phoneNumber,
    @RequestParam(name = "documentType") String documentType,
    @RequestParam(name = "numberAndSeries") String numberAndSeries) {

    ClientDTO clientDTO = new ClientDTO(firstName, lastName, middleName, gender, height, weight, phoneNumber);
    ProofOfIdentityDTO proofOfIdentityDTO = new ProofOfIdentityDTO(documentType, numberAndSeries);
    return domainClientServiceImpl.addClient(clientDTO, proofOfIdentityDTO);
  }
}
