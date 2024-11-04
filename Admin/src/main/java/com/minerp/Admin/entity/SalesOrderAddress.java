package com.minerp.Admin.entity;

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
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SalesOrderAddress {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private SalesOrder soId;
	private String address;
	private String pincode;
	private Area areaId;
	private String latitude;
	private String longitude;
}
