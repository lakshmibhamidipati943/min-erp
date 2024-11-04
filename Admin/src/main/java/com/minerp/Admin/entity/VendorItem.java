package com.minerp.Admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vendor_item")
public class VendorItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVendorItem;
	
	@Column(name="item_id")
	private Long itemId;
	
	@Column(name="vendor_id")
	private Long vendorId;
}
