package com.example.LogCollectorService.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.LogCollectorService.DTO.LogEvent;
// import com.example.LogCollectorService.Entity.Log;
// import com.example.LogCollectorService.Repo.LogRepo;
import com.example.LogCollectorService.Service.LogService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogConsumer {

      // private final LogRepo logRepo; 

      private final LogService logService;

      @KafkaListener(topics = "logs-topic" , groupId = "log-group" )
      public void consume(LogEvent event){

        //   Log log = Log.builder()
        //             .serviceName(event.getServiceName())
        //             .message(event.getMessage())
        //             .traceId(event.getTraceId())
        //             .timestamp(event.getTimestamp())
        //             .build();

        //      logRepo.save(log);

        logService.saveLog(event);


                    

      }

}
