package com.minerp.Admin.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVendor;
	private String vendorName;
	private String mobile;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;
	
	private String pincode;
	private Date createdDate;
	
	@ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
	private User createdBy;
	
	private Date modifiedDate;
	
	@ManyToOne
    @JoinColumn(name = "modified_by")
	private User modifiedBy;
	
	@ManyToMany
	@JoinTable(
	    name = "vendor_item",
	    joinColumns = @JoinColumn(name = "vendor_id"),
	    inverseJoinColumns = @JoinColumn(name = "item_id")
	)
	private List<Item> items;
	
	@OneToMany(mappedBy="vendorId", cascade=CascadeType.ALL)
	private List<PurchaseOrder> purchaseOrders;
	
	@OneToMany(mappedBy="vendor", cascade=CascadeType.ALL)
	private List<GoodsReceivedNotes> goodsReceivedNotes;
	
	@OneToMany(mappedBy="vendorId", cascade=CascadeType.ALL)
	private List<PurchaseInvoice> purchaseInvoices;
	
	@OneToMany(mappedBy="vendorId", cascade=CascadeType.ALL)
	private List<VendorPayment> vendorPayments;
}
