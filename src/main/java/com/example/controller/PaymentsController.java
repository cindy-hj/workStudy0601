package com.example.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Clients;
import com.example.model.Invoices;
import com.example.model.PaymentMethods;
import com.example.model.Payments;
import com.example.model.DTO.PaymentsDTO;
import com.example.service.ClientsService;
import com.example.service.InvoicesService;
import com.example.service.PaymentsService;

@RestController
public class PaymentsController {

	@Autowired
	private PaymentsService paymentsService;

	@Autowired
	private ClientsService clientsService;
	
	@Autowired
	private InvoicesService invoicesService;
	
	@PostMapping("/api/add/payment")
	public ResponseEntity addPayment(@RequestBody PaymentsDTO dto) {
		Clients client = clientsService.findById(dto.getClientid());
		Invoices invoice = invoicesService.findById(dto.getInvoiceid());
		PaymentMethods paymentmethod = paymentsService.findById(dto.getPaymentmethod());
	
		Payments payment = new Payments();
		
		payment.setAmount(dto.getAmount());
		payment.setClientid(client);
		payment.setInvoiceid(invoice);
		payment.setDate(LocalDateTime.now());
		payment.setPaymentmethod(paymentmethod);
		
		Payments result = paymentsService.save(payment);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
