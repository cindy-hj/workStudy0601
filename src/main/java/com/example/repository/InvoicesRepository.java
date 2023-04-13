package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Invoices;

public interface InvoicesRepository extends JpaRepository<Invoices, Long> {

}
