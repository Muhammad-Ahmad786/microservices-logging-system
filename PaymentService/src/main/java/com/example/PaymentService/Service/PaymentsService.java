package com.example.PaymentService.Service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.PaymentService.DTO.LogEvent;
import com.example.PaymentService.DTO.PaymentRequestDto;
import com.example.PaymentService.Util.TraceIdHolder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentsService {

    private final KafkaTemplate<String , LogEvent> kafkaTemplate;

    public String processPayment(PaymentRequestDto  request){


        boolean success = new Random().nextBoolean();     //simulate payment

        if(success){

            LogEvent log = new LogEvent(
                 "PAYMENT-SERVICE",
                 "Payment SUCCESSFUL for order: "+ request.getOrderId(), 
                 "INFO", 
                 TraceIdHolder.get(), 
                 LocalDateTime.now()
                );

                kafkaTemplate.send("logs-topic" , log);

                return "payment Successful";
        }
        else{
          
             LogEvent log = new LogEvent(
                 "PAYMENT-SERVICE",
                 "Payment FAILED for order: "+ request.getOrderId(), 
                 "ERROR", 
                 TraceIdHolder.get(), 
                 LocalDateTime.now()
                );

                kafkaTemplate.send("logs-topic" , log);

                return "Payment Failed";

        }
    }



}
