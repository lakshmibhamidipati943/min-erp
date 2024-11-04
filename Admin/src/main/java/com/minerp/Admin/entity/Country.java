package com.minerp.Admin.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCountry;
	private String countryCode;
	private String countryName;
	private String currencySymbol;
	
	@OneToMany(mappedBy="countryId", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<State> states; 
}
