package com.minerp.Admin.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_store")
	private Long idStore;
	private String code;
	private String storeName;
	private String address;
	private String pincode;
	private String latitude;
	private String longitude;
	
	@ManyToOne
	@JoinColumn(name="area_id")
	private Area areaId;

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Stock> stocks;
	
	@OneToMany(mappedBy = "storeId", cascade = CascadeType.ALL)
    private List<StockAdjustment> stockAdjustments; 
	
	@OneToMany(mappedBy="fromStoreId", cascade=CascadeType.ALL)
	private List<StockTransfer> outgoingStockTransfer;
	
	@OneToMany(mappedBy="toStoreId", cascade=CascadeType.ALL)
	private List<StockTransfer> incomingStockTransfer;
	
	@OneToMany(mappedBy="storeId", cascade=CascadeType.ALL)
	private List<PurchaseOrder> purchaseOrders;
	
	@OneToMany(mappedBy="store", cascade=CascadeType.ALL)
	private List<GoodsReceivedNotes> goodsReceivedNotes;
	
	@OneToMany(mappedBy="storeId", cascade=CascadeType.ALL)
	private List<PurchaseInvoice> purchaseInvoices;
	
}
