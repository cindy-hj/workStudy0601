package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.PaymentMethods;
import com.example.repository.PaymentMethodsRepository;

@Service
public class PaymentMethodsService {

	@Autowired	
	private PaymentMethodsRepository paymentMethodsRepository;

	public PaymentMethods save(PaymentMethods opaymentMethods) {
		return paymentMethodsRepository.save(opaymentMethods);
	}

	public void delete(Long id) {
		paymentMethodsRepository.deleteById(id);
	}
}
