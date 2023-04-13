package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Clients;
import com.example.model.DTO.ClientInvoiceDTO;
import com.example.model.DTO.ClientPaymentDTO;
import com.example.repository.ClientsRepository;

import jakarta.transaction.Transactional;

@Service
public class ClientsService {

	@Autowired
	private ClientsRepository clientsRepository;

	public Clients save(Clients addClient) {		
		return clientsRepository.save(addClient);
	}

	@Transactional
	public Clients update(Long id, String name, String address, String city, String state, String phone) {
		
		Clients client = clientsRepository.findById(id).get();
		Clients result = client.update(name, address, city, state, phone);
		
		
		return result;
	}

	public List<Clients> findAll() {

		return clientsRepository.findAll();
	}

	public void delete(Long id) {
		clientsRepository.deleteById(id);
		
	}

	public Clients findById(Long clientid) {

		return clientsRepository.findById(clientid).get();
	}
	
	public String clientCount() {
		return clientsRepository.clientCount();
	}

	public List<ClientInvoiceDTO> joinClientInvoice() {
		return clientsRepository.findClientInvoice();
	}

	public ClientPaymentDTO joinClientPayment(Long id) {
		return clientsRepository.findClientPayment(id);
	}



}
