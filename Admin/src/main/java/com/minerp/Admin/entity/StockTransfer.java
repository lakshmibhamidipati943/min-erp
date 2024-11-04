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
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockTransfer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "from_store_id", nullable = false)
	private Store fromStoreId;
	
	@ManyToOne
	@JoinColumn(name = "to_store_id", nullable = false)
	private Store toStoreId;
	
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item itemId;
	
	private Integer quantity;
	private String remarks;
	private Date createdDate;
	
	@ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
	private User createdBy;
}
