package com.example.rental.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.services.ProofOfIdentityService;

@RestController
@RequestMapping("/api/proof")
public class ProofOfIdentityController {

  @Autowired
  private ProofOfIdentityService proofOfIdentityService;

  @PostMapping("/verification")
  public void verificationProofOfIdentity(@RequestParam(name = "clientId") int id, @RequestParam(name = "date") LocalDate localDate) {
    proofOfIdentityService.verificationProofOfIdentity(id, localDate);
  }

}
