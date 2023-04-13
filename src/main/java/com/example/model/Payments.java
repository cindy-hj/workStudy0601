package com.example.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentid;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="clientid")
	private Clients clientid;
	
	//invoice id FK
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="invoiceid")
	private Invoices invoiceid;
	
	private LocalDateTime date;
	
	private String amount;
	
	//payment method FK
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="paymentmethod")
	private PaymentMethods paymentmethod;

}
