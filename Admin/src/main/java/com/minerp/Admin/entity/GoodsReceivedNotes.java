package com.minerp.Admin.entity;

import java.util.Date;
import java.util.List;

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
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsReceivedNotes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGrn;
	
	@ManyToOne
	@JoinColumn(name="vendor_id", nullable=false)
	private Vendor vendor;
	
	private Date receivedDate;
	private Integer quantity;
	
	private Date createdDate;
	private Date modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="store_id", nullable=false)
	private Store store;
	
	@ManyToOne
	@JoinColumn(name="created_by", nullable=false)
	private User createdBy;
		
	@ManyToOne
	@JoinColumn(name="modified_by", nullable=false)
	private User modifiedBy;
	
	@OneToMany(mappedBy="grnId", cascade=CascadeType.ALL)
	private List<GoodsReceivedNotesItems> goodsReceivedNotesItems;
	
}
