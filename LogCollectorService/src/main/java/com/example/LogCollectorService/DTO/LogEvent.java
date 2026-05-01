package com.example.LogCollectorService.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogEvent {

    private String serviceName;
    private String message;
    private String level;
    private String traceId;
    private LocalDateTime timestamp;


}
