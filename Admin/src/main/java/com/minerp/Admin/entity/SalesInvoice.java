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
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SalesInvoice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String invoiceNo;
	private Customer customer;
	private Date invoiceDate;
	private Double invoiceAmount;
	private Double deliveryCharges;
	private Double dueAmount;
	private Double paidAmount;
	private Integer quantity;
	private Store storeId;
	private SalesOrderAddress soaId;
	private Date createdDate;
	private User createdBy;
	private Date modifiedDate;
	private User modifiedBy;
	private SalesOrder soId;
}
