package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Clients;
import com.example.model.DTO.ClientInvoiceDTO;
import com.example.model.DTO.ClientPaymentDTO;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

	@Query("SELECT COUNT(*) FROM Clients")
	String clientCount();
	
	@Query(value="select "
			+ "new com.example.model.DTO.ClientInvoiceDTO(clients.name, clients.address, clients.city, "
			+ "clients.state, clients.phone, invoices.number, invoices.invoicetotal, invoices.paymenttotal) "
			+ "from Clients clients "
			+ "left outer join Invoices invoices with clients.clientid = invoices.clientid")
	List<ClientInvoiceDTO> findClientInvoice();
	
	@Query(value="select "
			+ "new com.example.model.DTO.ClientPaymentDTO(clients.name, clients.address, clients.city, "
			+ "clients.state, clients.phone, payments.amount) "
			+ "from Clients clients "
			+ "left outer join Payments payments with clients.clientid = payments.clientid "
			+ "where payments.paymentid = :id" )
	ClientPaymentDTO findClientPayment(@Param("id") Long id);
}
