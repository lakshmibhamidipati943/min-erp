package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.PurchaseOrderItems;

@Repository
public interface PurchaseOrderItemsRepository extends JpaRepository<PurchaseOrderItems, Long>{

	@Query(value="select * from purchase_order_items where purchase_order_id=?1", nativeQuery=true)
	List<PurchaseOrderItems> getPurchaseOrderItemsByPurchaseOrderId(Long purchaseOrderId, Pageable pageable);

}
