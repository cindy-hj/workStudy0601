package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PaymentMethods;
import com.example.model.DTO.PaymentMethodsDTO;
import com.example.service.PaymentMethodsService;

@RestController
public class PaymentMethodsController {
	
	@Autowired
	private PaymentMethodsService paymentMethodsService;

	@PostMapping("/api/add/paymentmethod")
	public ResponseEntity addPaymentmethod(@RequestBody PaymentMethodsDTO dto) {
		PaymentMethods opaymentMethods = new PaymentMethods();
		opaymentMethods.setName(dto.getName());
		
		PaymentMethods paymentmethod = paymentMethodsService.save(opaymentMethods);
		return new ResponseEntity<>(paymentmethod, HttpStatus.OK);
	}
	
	@DeleteMapping("/api/delete/paymentmethod/{id}")
	public ResponseEntity deletePaymentmethod(@PathVariable("id") Long id) {
		paymentMethodsService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
