package com.example.rental.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rental.domain.Bicycle;
import com.example.rental.dtos.BicycleDTO;

@Configuration
public class JavaConfig {
  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.createTypeMap(Bicycle.class, BicycleDTO.class);
    return modelMapper;
  }
}
