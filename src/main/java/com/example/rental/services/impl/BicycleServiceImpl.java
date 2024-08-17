package com.example.rental.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rental.domain.Bicycle;
import com.example.rental.domain.Client;
import com.example.rental.dtos.BicycleByAnthropometricDTO;
import com.example.rental.dtos.BicycleByFilterDTO;
import com.example.rental.dtos.ClientAnthropometricDTO;
import com.example.rental.repositories.impl.BicycleRepositoryImpl;
import com.example.rental.repositories.impl.ClientRepositoryImpl;
import com.example.rental.services.BicycleService;

@Service
public class BicycleServiceImpl implements BicycleService {
  @Autowired
  private BicycleRepositoryImpl bicycleRepositoryImpl;
  @Autowired
  private ClientRepositoryImpl clientRepositoryImpl;
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<BicycleByAnthropometricDTO> getBicycleByAnthropometricByClient(int id) {
    Client client = clientRepositoryImpl.findById(Client.class, id);
    ClientAnthropometricDTO clientAnthropometricDTO = modelMapper.map(client, ClientAnthropometricDTO.class);

    List<Bicycle> listBicycle = bicycleRepositoryImpl.getAvailableBicycleByStatus(true);
    List<BicycleByAnthropometricDTO> sortBicycle = listBicycle.stream()
      .filter(b -> b.getMaxHeight() >= clientAnthropometricDTO.getHeight())
      .filter(b -> b.getMaxWeight() >= clientAnthropometricDTO.getWeight())
      .map(b -> modelMapper.map(b, BicycleByAnthropometricDTO.class))
      .collect(Collectors.toList());

    return sortBicycle;
  }

  @Override
  public List<BicycleByFilterDTO> getBicycleByFilter(BicycleByFilterDTO bicycleByFilterDTO) {
    List<Bicycle> bicycles = bicycleRepositoryImpl.getBicycleByFilter(
        bicycleByFilterDTO.getManufacturer(),
        bicycleByFilterDTO.getModel(),
        bicycleByFilterDTO.getType(),
        bicycleByFilterDTO.getBrakesType(),
        bicycleByFilterDTO.getCostPerDay()
      );
    return bicycles.stream().map(b -> modelMapper.map(b, BicycleByFilterDTO.class)).collect(Collectors.toList());
  }

}
