package com.example.UserService.DTO;

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
    private String traceId;
    private String level;
    private LocalDateTime timestamp;

}
