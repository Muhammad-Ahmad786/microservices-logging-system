package com.example.UserService.Service;

import java.time.LocalDateTime;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.UserService.DTO.LogEvent;
import com.example.UserService.Util.TraceIdHolder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceLogic {

    private final KafkaTemplate<String , LogEvent> kafkaTemplate;

    public String createUser(){
        LogEvent log = new LogEvent(
              "USER-SERVICE",
              "USER-CREATED",
              TraceIdHolder.get(),
              "INFO",
              LocalDateTime.now()
            );

            kafkaTemplate.send("logs-topic" , log);

            return "USER-CREATED";

    }



}
