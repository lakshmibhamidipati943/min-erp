package com.minerp.Admin.entity;

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
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPurchaseOrederItems;
	
	@ManyToOne
	@JoinColumn(name="purchaseorder_id", nullable=false)
	private PurchaseOrder poId;
	
	@ManyToOne
	@JoinColumn(name="item_id", nullable=false)
	private Item itemId;
	
	private Integer quantity;
	private Double rate;
	
	@ManyToOne
	@JoinColumn(name="uom_id", nullable=false)
	private UOM uomId;
	
	private Double purchasePrice;	
}
