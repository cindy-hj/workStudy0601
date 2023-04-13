package com.example.model.DTO;

import lombok.Data;

@Data
public class PaymentsDTO {
	
	private Long clientid;
	private Long invoiceid;
	private String amount;
	public Long getPaymentmethod() {
		// TODO Auto-generated method stub
		return null;
	}


}
