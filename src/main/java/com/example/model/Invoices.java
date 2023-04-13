package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="invoices")
public class Invoices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceid;
	
	private String number;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="clientid")
	private Clients clientid;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "invoiceid")
	private List<Payments> payments;
	
	private String invoicetotal;
	
	private String paymenttotal;
	
	private LocalDateTime invoicedate;
	
	private LocalDateTime duedate;
	
	private LocalDateTime paymentdate;
	
	
	public Invoices update(String number, Clients clientid,
			String invoicetotal, String paymenttotal,
			LocalDateTime invoicedate,
			LocalDateTime duedate,
			LocalDateTime paymentdate) {
		this.number = number;
		this.clientid = clientid;
		this.invoicetotal = invoicetotal;
		this.paymenttotal = paymenttotal;
		this.invoicedate = invoicedate;
		this.duedate = duedate;
		this.paymentdate = paymentdate;
		
		return this;
	}
}
