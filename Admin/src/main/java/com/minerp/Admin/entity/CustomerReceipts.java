package com.minerp.Admin.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerReceipts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private SalesInvoice invoiceId;
	private Double amount;
	private Date paymentDate;
	private Date createdDate;
	private User createdBy;
	private PaymentMode modeId;
	private Customer customer;
}
