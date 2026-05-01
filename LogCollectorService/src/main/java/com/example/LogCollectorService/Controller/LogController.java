package com.example.LogCollectorService.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LogCollectorService.Entity.Log;
import com.example.LogCollectorService.Service.LogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @GetMapping
    public ResponseEntity<List<Log>> getAll(){

        return ResponseEntity.status(HttpStatus.OK).body(logService.getAllLogs());
    }

    @GetMapping("/trace/{traceId}")
    public ResponseEntity<List<Log>> findByTraceID(@PathVariable String traceId){

        return ResponseEntity.status(HttpStatus.OK).body(logService.findByTraceId(traceId));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<Log>> findByLevel(@PathVariable String level){

        return ResponseEntity.status(HttpStatus.OK).body(logService.findByLevel(level));
    }


}
