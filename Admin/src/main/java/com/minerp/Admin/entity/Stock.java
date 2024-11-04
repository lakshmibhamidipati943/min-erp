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

public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStock;
	
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;
	
	@ManyToOne
    @JoinColumn(name = "item_id", nullable = false) 
	private Item item;
	
	private Integer quantity;
	private Integer reorderLevel;
	private Integer overflowLevel;
}
