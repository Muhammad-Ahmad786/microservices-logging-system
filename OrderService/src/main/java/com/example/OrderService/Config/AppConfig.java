package com.example.OrderService.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.OrderService.DTO.OrderDto;
import com.example.OrderService.Entity.Order;

@Configuration
public class AppConfig {
 
   
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        // IMPORTANT: stop ambiguous mapping errors
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        // DTO -> Entity
        modelMapper.typeMap(OrderDto.class, Order.class).addMappings(mapper -> {
            mapper.skip(Order::setId);
            mapper.skip(Order::setStatus); // optional but safer
        });

        return modelMapper;
    }

}
