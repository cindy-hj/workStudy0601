package com.example.model.DTO;

import com.example.model.Clients;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
	
	private String name;
	private String address;
	private String city;
	private String state;
	private String phone;
	
	public ClientDTO(Clients entity) {
		this.name = entity.getName();
		this.address = entity.getAddress();
		this.city = entity.getCity();
		this.state = entity.getState();
		this.phone = entity.getPhone();
	}
	
	
}
