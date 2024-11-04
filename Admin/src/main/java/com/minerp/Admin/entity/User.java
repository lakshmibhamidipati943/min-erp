package com.minerp.Admin.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Username is required")
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters")
	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message="Username can only contain letters, numbers and underscores")
	private String username;
	
	@NotBlank(message="Password is required")
	@Size(min=8, message="Password must be at least 8 characters long")
	@Pattern(
			regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
			message="Password must contain atleast one digit, one lowercase letter, one uppercase letter, and one special character")
	private String password;
	private Boolean status;
	
	private String role;
	
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<StockAdjustment> stockAdjustments; 
	
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
	private List<StockTransfer> stockTransfers;
	
	@OneToMany(mappedBy= "createdBy", cascade=CascadeType.ALL)
	private List<Vendor> createdVendors;
	
	@OneToMany(mappedBy= "modifiedBy", cascade=CascadeType.ALL)
	private List<Vendor> modifiedVendors;
	
	@OneToMany(mappedBy= "createdBy", cascade=CascadeType.ALL)
	private List<PurchaseOrder> createdPurchaseOrders;
	
	@OneToMany(mappedBy= "modifiedBy", cascade=CascadeType.ALL)
	private List<PurchaseOrder> modifiedPurchaseOrders;
	
	@OneToMany(mappedBy="createdBy", cascade=CascadeType.ALL)
	private List<GoodsReceivedNotes> createdGoodReceivedNotes;
	
	@OneToMany(mappedBy="modifiedBy", cascade=CascadeType.ALL)
	private List<GoodsReceivedNotes> modifiedGoodReceivedNotes;
	
	@OneToMany(mappedBy="createdBy", cascade=CascadeType.ALL)
	private List<PurchaseInvoice> createdPurchaseInvoice;
	
	@OneToMany(mappedBy="modifiedBy", cascade=CascadeType.ALL)
	private List<PurchaseInvoice> modifiedPurchaseInvoice;
	
	@OneToMany(mappedBy="createdBy", cascade=CascadeType.ALL)
	private List<VendorPayment> vendorPayment;
}
