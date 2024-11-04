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
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryNotesItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private DeliveryNotes dnId;
	private Item itemId;
	private Integer quantity;
	private UOM uomId;
}
