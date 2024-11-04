package com.minerp.Admin.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idItem;
	private String itemCode;
	private String itemName;
	private Double mrp;
	private Double costPrice;
	private Double SellingPrice;
	
	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;	
	
	@ManyToOne
	@JoinColumn(name = "uom_id", nullable = false)
	private UOM uom;
	
	@ManyToMany(mappedBy = "items")
	private List<Vendor> vendors;
	
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<Stock> stocks;
	
	@OneToMany(mappedBy="itemId", cascade=CascadeType.ALL)
	private List<StockAdjustment> stockAdjustments;
	
	@OneToMany(mappedBy="itemId", cascade=CascadeType.ALL)
	private List<StockTransfer> stockTransfer;

	@OneToMany(mappedBy="itemId", cascade=CascadeType.ALL)
	private List<PurchaseOrderItems> purchaseOrderItems;
	
	@OneToMany(mappedBy="itemId", cascade=CascadeType.ALL)
	private List<GoodsReceivedNotesItems> goodsReceivedNotesItems;
}
