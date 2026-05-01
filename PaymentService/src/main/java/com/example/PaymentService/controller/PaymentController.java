package com.example.PaymentService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PaymentService.DTO.PaymentRequestDto;
import com.example.PaymentService.Service.PaymentsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentsService paymentsService;

    @PostMapping
    public String processPayment(@RequestBody PaymentRequestDto request){
        return paymentsService.processPayment(request);
    }

}
