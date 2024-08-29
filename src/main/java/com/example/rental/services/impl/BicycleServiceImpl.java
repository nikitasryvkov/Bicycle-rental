package com.example.rental.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rental.domain.Bicycle;
import com.example.rental.domain.Client;
import com.example.rental.domain.enums.BicycleStatus;
import com.example.rental.dtos.BicycleDTO;
import com.example.rental.dtos.BicycleByFilterDTO;
import com.example.rental.dtos.ClientAnthropometricDTO;
import com.example.rental.repositories.BicycleRepository;
import com.example.rental.repositories.ClientRepository;
import com.example.rental.services.BicycleService;

@Service
public class BicycleServiceImpl implements BicycleService {
  @Autowired
  private BicycleRepository bicycleRepository;
  @Autowired
  private ClientRepository clientRepository;
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public BicycleDTO addBicycle(BicycleDTO bicycleDTO) {
    Bicycle bicycle = new Bicycle(
      bicycleDTO.getManufacturer(),
      bicycleDTO.getModel(),
      bicycleDTO.getBicycleType(),
      bicycleDTO.getNumberOfSpeeds(),
      bicycleDTO.getMaxHeight(),
      bicycleDTO.getMaxWeight(),
      bicycleDTO.getBrakesType(),
      bicycleDTO.getCostPerDay(),
      bicycleDTO.getBicycleStatus());

    bicycleRepository.save(bicycle);

    return modelMapper.map(bicycle, BicycleDTO.class);
  }

  @Override
  public List<BicycleDTO> getBicycleByAnthropometricByClient(int id) {
    Client client = clientRepository.findById(Client.class, id).get();
    ClientAnthropometricDTO clientAnthropometricDTO = modelMapper.map(client, ClientAnthropometricDTO.class);

    List<Bicycle> listBicycle = bicycleRepository.getAvailableBicycleByStatus(BicycleStatus.AVAILABLE);
    List<BicycleDTO> sortBicycle = listBicycle.stream()
      .filter(b -> b.getMaxHeight() >= clientAnthropometricDTO.getHeight())
      .filter(b -> b.getMaxWeight() >= clientAnthropometricDTO.getWeight())
      .map(b -> modelMapper.map(b, BicycleDTO.class))
      .collect(Collectors.toList());

    return sortBicycle;
  }

  @Override
  public List<BicycleByFilterDTO> getBicycleByFilter(BicycleByFilterDTO bicycleByFilterDTO) {
    List<Bicycle> bicycles = bicycleRepository.getBicycleByFilter(
        bicycleByFilterDTO.getManufacturer(),
        bicycleByFilterDTO.getModel(),
        bicycleByFilterDTO.getBicycleType(),
        bicycleByFilterDTO.getBrakesType(),
        bicycleByFilterDTO.getCostPerDay()
      );
    return bicycles.stream().map(b -> modelMapper.map(b, BicycleByFilterDTO.class)).collect(Collectors.toList());
  }

}
