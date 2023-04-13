package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {

}
