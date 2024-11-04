package com.minerp.Admin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>{

	@Query(value="select * from purchase_order", nativeQuery=true)
	List<PurchaseOrder> getAllPurchaseOrders(Pageable pageable);

	@Query(value="select * from purchase_order where created_date in (fromDate,toDate)",nativeQuery=true)
	List<PurchaseOrder> getBetweenPurchaseOrders(Date fromDate, Date toDate, Pageable pageable);

	@Query(value="select * from purchase_order where store_id=?1", nativeQuery=true)
	List<PurchaseOrder> getPurchaseOrdersByStoreId(Long storeId, Pageable pageable);

	@Query(value="select * from purchase_order where id_purchase_order=?1", nativeQuery=true)
	PurchaseOrder getPurchaseOrderById(Long idPurchaseOrder);

	@Query(value="select * from purchase_order where vendor_id=?1", nativeQuery=true)
	List<PurchaseOrder> getPurchaseOrdersByVendorId(Long vendorId, Pageable pageable);

}
