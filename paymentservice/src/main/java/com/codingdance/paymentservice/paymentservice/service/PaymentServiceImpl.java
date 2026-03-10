package com.codingdance.paymentservice.service;

import com.codingdance.paymentservice.entity.TransactionDetails;
import com.codingdance.paymentservice.model.PaymentRequest;
import com.codingdance.paymentservice.repository.TransactionDetailsRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    
    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("Recoding Payment Details:{}", paymentRequest);
        TransactionDetails transactionDetails = TransactionDetails.builder()
                .orderId(paymentRequest.getOrderId())
                .paymentMethod(paymentRequest.getPaymentMode())
                .amount(paymentRequest.getAmount())
                .paymentDate(Instant.now())
                .paymentStatus("SUCCESS")
                .referenceNumber(paymentRequest.getReferenceNumber())
                .build();
        transactionDetailsRepository.save(transactionDetails);
        log.info("Transaction Completed with Transaction ID: {}", transactionDetails.getId());
        
        return transactionDetails.getId();}
    
}
