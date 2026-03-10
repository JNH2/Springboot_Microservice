package com.codingdance.paymentservice.repository;

import com.codingdance.paymentservice.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {
    // Custom query methods can be defined here if needed
}   
