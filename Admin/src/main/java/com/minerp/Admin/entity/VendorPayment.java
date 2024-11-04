package com.minerp.Admin.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendorPayment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVendorPayment;
	
	@ManyToOne
	@JoinColumn(name="invoice_id", nullable=false)
	private PurchaseInvoice invoiceId;
	
	private Double amount;
	private Date paymentDate;
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name="created_by", nullable=false)
	private User createdBy;
	
	@ManyToOne
	@JoinColumn(name="mode_id", nullable=false)
	private PaymentMode modeId;
	
	@ManyToOne
	@JoinColumn(name="vendor_id", nullable=false)
	private Vendor vendorId;
}
