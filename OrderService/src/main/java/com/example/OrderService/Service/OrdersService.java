package com.example.OrderService.Service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.OrderService.DTO.LogEvent;
import com.example.OrderService.DTO.OrderDto;
import com.example.OrderService.Entity.Order;
import com.example.OrderService.Repo.OrderRepo;
import com.example.OrderService.Util.TraceIdHolder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;
    private final KafkaTemplate<String,LogEvent> kafkaTemplate;
    private static final String orderService = "ORDERS-SERVICE";
    private static final String level = "INFO";

    public OrderDto createOrder(OrderDto dto){
         
        Order order = modelMapper.map(dto, Order.class);
        
        order.setStatus("CREATED");

        Order savedOrder = orderRepo.save(order);

        String traceId = TraceIdHolder.get();

        if(traceId == null){
            traceId = "N/A";
        }

        LogEvent log = new LogEvent(
              orderService,
              "ORDER-CREATED with ID: "+savedOrder.getId(),
              level,
              traceId,
              LocalDateTime.now()
            );

            kafkaTemplate.send("logs-topic" , log);

            return modelMapper.map(savedOrder, OrderDto.class);
    }


}
