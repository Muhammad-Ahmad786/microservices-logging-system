package com.example.OrderService.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogEvent {

    private String serviceName;

    //@JsonProperty("message")
    private String message;
    private String level;
    private String traceId;
    private LocalDateTime timestamp;  

}
