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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCity;
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private State stateId;
	
	@OneToMany(mappedBy="cityId", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Area> areas;
}
