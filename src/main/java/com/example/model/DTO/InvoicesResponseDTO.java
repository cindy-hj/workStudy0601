package com.example.model.DTO;

import java.time.LocalDateTime;

import com.example.model.Clients;
import com.example.model.Invoices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoicesResponseDTO {
	private String number;
	private Clients clientid;
	private String invoicetotal;	
	private String paymenttotal;	
	private LocalDateTime invoicedate;	
	private LocalDateTime duedate;	
	private LocalDateTime paymentdate;
	
	public InvoicesResponseDTO(Invoices entity) {
		this.number = entity.getNumber();
		this.clientid = entity.getClientid();
		this.invoicetotal = entity.getInvoicetotal();
		this.paymenttotal = entity.getPaymenttotal();
		this.invoicedate = entity.getInvoicedate();
		this.duedate = entity.getDuedate();
		this.paymentdate = entity.getPaymentdate();
	}
}
