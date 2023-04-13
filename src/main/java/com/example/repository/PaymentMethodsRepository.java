package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.PaymentMethods;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Long> {

}
