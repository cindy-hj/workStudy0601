package com.example.model.DTO;

import java.time.LocalDateTime;

import com.example.model.Clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoicesDTO {
	private String number;
	private String clientid;
	private String invoicetotal;	
	private String paymenttotal;	
	private LocalDateTime invoicedate;	
	private LocalDateTime duedate;	
	private LocalDateTime paymentdate;
	
	
}
