package com.codingdance.paymentservice.service;

import com.codingdance.paymentservice.model.PaymentRequest;


public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);  
} 