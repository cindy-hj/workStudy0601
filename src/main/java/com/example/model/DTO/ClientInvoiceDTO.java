package com.example.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientInvoiceDTO {
	private String name;
	private String address;
	private String city;
	private String state;
	private String phone;
	private String number;
	private String invoicetotal;
	private String paymenttotal;
}
