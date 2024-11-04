package com.minerp.Admin.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="area")
public class Area {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idArea;
	private String areaName;
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City cityId;
	
	@OneToMany(mappedBy="areaId", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Store> stores;
	
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
    private List<Vendor> vendors;
}
