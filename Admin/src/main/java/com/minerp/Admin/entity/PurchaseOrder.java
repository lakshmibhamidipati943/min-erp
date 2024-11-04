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
@Setter
@Getter	
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPurchaseOrder;
	private Date orderDate;
	private Double orderAmount;
	private Integer quantity;
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name="created_by", nullable=false)
	private User createdBy;
	
	private Date modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="modified_by", nullable=false)
	private User modifiedBy;
	
	@ManyToOne
	@JoinColumn(name="store_id", nullable=false)
	private Store storeId;
	
	@OneToMany(mappedBy="poId", cascade=CascadeType.ALL)
	private List<PurchaseOrderItems> purchaseOrderItems;
	
	@ManyToOne
	@JoinColumn(name="vendor_id", nullable=false)
	private Vendor vendorId;
	
	@OneToOne(mappedBy="poId", cascade=CascadeType.ALL)
	private PurchaseInvoice purchaseInvoice;
	
	
}
