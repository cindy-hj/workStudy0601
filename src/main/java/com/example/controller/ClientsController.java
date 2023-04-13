package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Clients;
import com.example.model.DTO.ClientDTO;
import com.example.model.DTO.ClientInvoiceDTO;
import com.example.model.DTO.ClientPaymentDTO;
import com.example.service.ClientsService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ClientsController {

	@Autowired
	private ClientsService clientsService;
	
	@PostMapping("/api/add/client")
	public ResponseEntity addClient(@RequestParam("name") String name,
			@RequestParam("address")String address, @RequestParam("city") String city,
			@RequestParam("state")String state, @RequestParam("phone") String phone,
			HttpServletResponse res) throws IOException {
		Clients addClient = new Clients();
		addClient.setName(name);
		addClient.setAddress(address);
		addClient.setCity(city);
		addClient.setState(state);
		addClient.setPhone(phone);
		
		Clients result = clientsService.save(addClient);
		
		res.sendRedirect("http://localhost:8080/addclient");
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PostMapping("/api/add2/client")
	public ResponseEntity add2Client(@RequestBody Map<String, String> params) {
		String name = params.get("name");
		String address = params.get("address");
		String city = params.get("city");
		String state = params.get("state");
		String phone = params.get("phone");
		
		Clients addClient = new Clients();
		addClient.setName(name);
		addClient.setAddress(address);
		addClient.setCity(city);
		addClient.setState(state);
		addClient.setPhone(phone);
		
		Clients result = clientsService.save(addClient);
		
		return new ResponseEntity<>(result,HttpStatus.OK);
		
		
	}
	
	@PostMapping("/api/add3/client")
	public ResponseEntity add3Client(@RequestBody Map<String, Object> params) {
		String name =(String)params.get("name");
		String address =(String)params.get("address");
		String city =(String)params.get("city");
		String state = (String)params.get("state");
		String phone = (String)params.get("phone");
		
		Clients addClient = new Clients();
		addClient.setName(name);
		addClient.setAddress(address);
		addClient.setCity(city);
		addClient.setState(state);
		addClient.setPhone(phone);
		
		Clients result = clientsService.save(addClient);
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PostMapping("/api/add4/client")
	public ResponseEntity add3Client(@RequestBody ClientDTO clientdto) {
		
		Clients addClient = new Clients();
		addClient.setName(clientdto.getName());
		addClient.setAddress(clientdto.getAddress());
		addClient.setCity(clientdto.getCity());
		addClient.setState(clientdto.getState());
		addClient.setPhone(clientdto.getPhone());
		
		
		Clients result = clientsService.save(addClient);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PutMapping("/api/edit/client/{id}")
	public ResponseEntity editClient(@PathVariable("id")Long id, @RequestParam("name") String name,
			@RequestParam("address")String address, @RequestParam("city") String city,
			@RequestParam("state")String state, @RequestParam("phone") String phone,
			HttpServletResponse res) {
		Clients result = clientsService.update(id, name,address,city,state,phone);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/api/edit2/client/{id}")
	public ResponseEntity edit2Client(@PathVariable("id")Long id, @RequestBody Map<String, String> params) {
		String name = params.get("name");
		String address = params.get("address");
		String city = params.get("city");
		String state = params.get("state");
		String phone = params.get("phone");
	
		Clients result = clientsService.update(id, name, address, city, state, phone);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PutMapping("/api/edit3/client/{id}")
	public ResponseEntity edit3Client(@PathVariable("id")Long id, @RequestBody Map<String, Object> params) {
		String name = (String)params.get("name");
		String address = (String)params.get("address");
		String city = (String)params.get("city");
		String state = (String)params.get("state");
		String phone = (String)params.get("phone");
	
		Clients result = clientsService.update(id, name, address, city, state, phone);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PutMapping("/api/edit4/client/{id}")
	public ResponseEntity edit4Client(@PathVariable("id")Long id, @RequestBody ClientDTO clientdto) {
		Clients result = clientsService.update(id, clientdto.getName(),
												clientdto.getAddress(),
												clientdto.getCity(),
												clientdto.getState(),
												clientdto.getPhone());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/api/get/client")
	public ResponseEntity getClient() {
		List<Clients> lists = clientsService.findAll();
		
//		List<ClientDTO> dtolists= new ArrayList<>();
//		
//		for(Clients list:lists) {
//			ClientDTO dto = new ClientDTO();
//			dto.setName(list.getName());
//			dto.setAddress(list.getAddress());
//			dto.setCity(list.getCity());
//			dto.setState(list.getState());
//			dto.setPhone(list.getPhone());
//			
//			dtolists.add(dto);			
//		}
		
		List<ClientDTO> dtolists = lists.stream().map(ClientDTO::new).collect(Collectors.toList());
		
		return new ResponseEntity<>(dtolists, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/api/delete/client/{id}")
	public ResponseEntity deleteClient(@PathVariable("id")Long id) {
		
		clientsService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/api/count/client")
	public ResponseEntity countClient() {
		String count = clientsService.clientCount();
		
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
	
	@GetMapping("/api/join/clientinvoice")
	public ResponseEntity joinClientInvoice() {
		List<ClientInvoiceDTO> lists = clientsService.joinClientInvoice();
		
		return new ResponseEntity<>(lists, HttpStatus.OK);
	}
	
	@GetMapping("/api/join/clientpayment/{id}")
	public ResponseEntity joinClientPayment(@PathVariable("id")Long id) {
		ClientPaymentDTO result = clientsService.joinClientPayment(id);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
