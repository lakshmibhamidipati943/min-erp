package com.minerp.Admin.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class UOM {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUom;
	private String unitOfMeasurement;
	
	@OneToMany(mappedBy = "uom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;
	
	@OneToMany(mappedBy="uomId", cascade=CascadeType.ALL)
	private List<PurchaseOrderItems> purchaseOrderItems;
	
	@OneToMany(mappedBy="uomId", cascade=CascadeType.ALL)
	private List<GoodsReceivedNotesItems> goodsReceivedNotesItems;
}
