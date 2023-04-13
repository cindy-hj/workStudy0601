package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Clients;
import com.example.model.Invoices;
import com.example.repository.ClientsRepository;
import com.example.repository.InvoicesRepository;

import jakarta.transaction.Transactional;

@Service
public class InvoicesService {
	
	@Autowired
	private InvoicesRepository invoicesRepository;
	
	@Autowired
	private ClientsRepository clientsRepository;

	public Invoices save(Invoices invoices) {
		
		return invoicesRepository.save(invoices);
	}

	public Invoices findById(Long id) {

		return invoicesRepository.findById(id).get();
	}

	@Transactional
	public Invoices update(Long id, String number, String invoicetotal, String paymenttotal, String clientid) {
		
		Invoices invoice = invoicesRepository.findById(id).get();
		
		Clients client = clientsRepository.findById(Long.parseLong(clientid)).get();
		
		Invoices result = invoice.update(number, client, invoicetotal, paymenttotal, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
		
		return result;
	}

	public List<Invoices> findAll() {

		return invoicesRepository.findAll();
	}

	public void delete(Long id) {
		invoicesRepository.deleteById(id);
		
	}
}
