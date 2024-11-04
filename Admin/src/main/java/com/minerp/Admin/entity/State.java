package com.minerp.Admin.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class State {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idState;
	private String stateName;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country countryId;
	
	@OneToMany(mappedBy="stateId", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<City> cities;
	
}
