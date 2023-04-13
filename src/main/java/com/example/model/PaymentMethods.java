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
import lombok.Data;

@Data
@Entity
@Table(name="payment_methods")
public class PaymentMethods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentmethodid;
	
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "paymentmethod",fetch = FetchType.LAZY)
	private List<Payments> payments;
}
