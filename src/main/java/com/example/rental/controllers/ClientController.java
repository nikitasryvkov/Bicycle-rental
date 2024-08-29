package com.example.rental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.domain.enums.GenderType;
import com.example.rental.dtos.ClientDTO;
import com.example.rental.dtos.ProofOfIdentityDTO;
import com.example.rental.services.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

  @Autowired
  public ClientService clientService;

  @PostMapping()
  public ClientDTO create(
    @RequestParam(name = "firstName") String firstName,
    @RequestParam(name = "lastName") String lastName,
    @RequestParam(name = "middleName") String middleName,
    @RequestParam(name = "gender") GenderType genderType,
    @RequestParam(name = "height") int height,
    @RequestParam(name = "weight") int weight,
    @RequestParam(name = "phoneNumber") String phoneNumber,
    @RequestParam(name = "documentType") String documentType,
    @RequestParam(name = "numberAndSeries") String numberAndSeries) {

    ClientDTO clientDTO = new ClientDTO(firstName, lastName, middleName, genderType, height, weight, phoneNumber);
    ProofOfIdentityDTO proofOfIdentityDTO = new ProofOfIdentityDTO(documentType, numberAndSeries);
    return clientService.addClient(clientDTO, proofOfIdentityDTO);
  }
}
