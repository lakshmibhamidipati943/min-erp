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
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodsReceivedNotesItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGrnitems;
	
	@ManyToOne
	@JoinColumn(name="grn_id", nullable=false)
	private GoodsReceivedNotes grnId;
	
	@ManyToOne
	@JoinColumn(name="item_id", nullable=false)
	private Item itemId;
	
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="uom_id", nullable=false)
	private UOM uomId;
}
