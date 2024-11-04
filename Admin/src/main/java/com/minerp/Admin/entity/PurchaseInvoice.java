package com.minerp.Admin.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseInvoice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPurchaseInvoice;
	private String invoiceNumber;
	
	@ManyToOne
	@JoinColumn(name="vendor_id", nullable=false)
	private Vendor vendorId;
	
	private Date invoiceDate;
	private Double invoiceAmount;
	private Double dueAmount;
	private Double paidAmount;
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="store_id", nullable=false)
	private Store storeId;
	
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name="created_by", nullable=false)
	private User createdBy;
	
	private Date modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="modified_by", nullable=false)
	private User modifiedBy;
	
	@OneToOne
	@JoinColumn(name="purchase_order_id", nullable=false)
	private PurchaseOrder poId;
	
	@OneToMany(mappedBy="invoiceId", cascade=CascadeType.ALL)
	private List<VendorPayment> vendorPayments;
}
