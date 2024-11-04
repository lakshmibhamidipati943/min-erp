package com.minerp.Admin.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPaymentMode;
	private String paymentMode;
	
	@OneToMany(mappedBy="modeId", cascade=CascadeType.ALL)
	private List<VendorPayment> vendorPayments;
}
