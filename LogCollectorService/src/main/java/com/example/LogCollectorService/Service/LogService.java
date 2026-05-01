package com.example.LogCollectorService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LogCollectorService.DTO.LogEvent;
import com.example.LogCollectorService.Entity.Log;
import com.example.LogCollectorService.Repo.LogRepo;

@Service
public class LogService {

    private final LogRepo logRepo;

    public LogService(LogRepo logRepo) {
        this.logRepo = logRepo;
    }

    public void saveLog(LogEvent event){
          Log log = Log.builder()
                    .serviceName(event.getServiceName())
                    .message(event.getMessage())
                    .traceId(event.getTraceId())
                    .level(event.getLevel())
                    .timestamp(event.getTimestamp())
                    .build();

             logRepo.save(log);   
            
      }

    

    public List<Log> getAllLogs(){

        return logRepo.findAll();
    }  
    

     public List<Log> findByTraceId(String traceId){

          return logRepo.findByTraceId(traceId);
        
     } 


     public List<Log> findByLevel(String level){

        return logRepo.findByLevelIgnoreCase(level);
     }

}
