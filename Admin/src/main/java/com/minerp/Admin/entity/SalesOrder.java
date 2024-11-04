package com.minerp.Admin.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class SalesOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Customer customer;
	private Date orderDate;
	private Double orderAmount;
	private Integer quantity;
	private Store storeId;
	private Date createdDate;
	private User createdBy;
	private Date modifiedDate;
	private User modifiedBy;
}
