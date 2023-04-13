package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="clients")
public class Clients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientid;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String phone;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "clientid",fetch = FetchType.LAZY)
	private List<Invoices> invoices;

	@JsonManagedReference
	@OneToMany(mappedBy = "clientid",fetch = FetchType.LAZY)
	private List<Payments> payments;
	
	@Builder
	public Clients(String name,
						String address,
						String city,
						String state,
						String phone) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		
	}
	
	
	public Clients update(String name,
						String address,
						String city,
						String state,
						String phone) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		
		return this;
	}
}
