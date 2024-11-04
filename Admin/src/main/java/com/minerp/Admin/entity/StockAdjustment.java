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
@NoArgsConstructor
@AllArgsConstructor
public class StockAdjustment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="store_id", nullable=false)
	private Store storeId;
	
	@ManyToOne
	@JoinColumn(name="item_id", nullable=false)
	private Item itemId;
	
	private String transactionType;
	private Integer quantity;
	private String remarks;
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name="username", nullable=false)
	private User createdBy;
}
