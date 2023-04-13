package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.PaymentMethods;
import com.example.model.Payments;
import com.example.repository.PaymentMethodsRepository;
import com.example.repository.PaymentsRepository;

@Service
public class PaymentsService {
	
	@Autowired
	private PaymentMethodsRepository paymentMethodsRepository;

	@Autowired
	private PaymentsRepository paymentsRepository;
	
	public PaymentMethods findById(Long paymentmethod) {
		return paymentMethodsRepository.findById(paymentmethod).get();
	}

	public Payments save(Payments payment) {
		return paymentsRepository.save(payment);
	}
}
