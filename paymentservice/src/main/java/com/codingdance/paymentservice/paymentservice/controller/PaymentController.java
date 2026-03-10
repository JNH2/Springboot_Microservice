package com.codingdance.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.codingdance.paymentservice.model.PaymentRequest;
import com.codingdance.paymentservice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    
    @PostMapping("/doPayment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
        long transactionId = paymentService.doPayment(paymentRequest);
        return new ResponseEntity<>(transactionId, HttpStatus.OK);
    }    
}
