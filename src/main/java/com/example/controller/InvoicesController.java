package com.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Clients;
import com.example.model.Invoices;
import com.example.model.DTO.InvoicesDTO;
import com.example.model.DTO.InvoicesResponseDTO;
import com.example.service.ClientsService;
import com.example.service.InvoicesService;

@RestController
public class InvoicesController {

	@Autowired
	private InvoicesService invoicesService;
	
	@Autowired
	private ClientsService clientsService;
	
	@PostMapping("/api/add/invoice")
	public ResponseEntity addInvoice(@RequestBody InvoicesDTO dto) {
		
		Clients client = clientsService.findById(Long.parseLong(dto.getClientid())); 
		
		Invoices invoices = new Invoices();
		
		invoices.setNumber(dto.getNumber());
		invoices.setClientid(client);
		invoices.setInvoicetotal(dto.getInvoicetotal());
		invoices.setPaymenttotal(dto.getPaymenttotal());
		invoices.setInvoicedate(LocalDateTime.now());
		invoices.setDuedate(LocalDateTime.now());
		invoices.setPaymentdate(LocalDateTime.now());
		
		Invoices result = invoicesService.save(invoices);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
		
	}
	
	@PutMapping("/api/edit/invoice/{id}")
	public ResponseEntity editInvoice(@PathVariable Long id, @RequestBody InvoicesDTO dto) {
		
		Invoices invoice = invoicesService.update(id,dto.getNumber(),dto.getInvoicetotal(), dto.getPaymenttotal(),dto.getClientid());
		
		return new ResponseEntity<>(invoice, HttpStatus.OK);
		
	}
	
	@GetMapping("/api/get/invoice")
	public ResponseEntity getInvoice() {
		List<Invoices> lists = invoicesService.findAll();
		
//		List<InvoicesResponseDTO> rslists = new ArrayList<>();
//		
//		for(Invoices list:lists) {
//			InvoicesResponseDTO rsData = new InvoicesResponseDTO();
//			
//			rsData.setNumber(list.getNumber());
//			rsData.setInvoicetotal(list.getInvoicetotal());
//			rsData.setPaymenttotal(list.getPaymenttotal());
//			rsData.setClientid(list.getClientid());
//			rsData.setInvoicedate(list.getInvoicedate());
//			rsData.setDuedate(list.getDuedate());
//			rsData.setPaymentdate(list.getPaymentdate());
//			
//			rslists.add(rsData);
//		}
		
		List<InvoicesResponseDTO> rslists = lists.stream().map(InvoicesResponseDTO::new).collect(Collectors.toList());
		
		return new ResponseEntity<>(rslists, HttpStatus.OK);
	}
	
	@DeleteMapping("/api/delete/invoice/{id}")
	public ResponseEntity deleteInvoice(@PathVariable Long id) {
		invoicesService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
