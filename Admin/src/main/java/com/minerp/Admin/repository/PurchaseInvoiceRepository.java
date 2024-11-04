package com.minerp.Admin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.PurchaseInvoice;

@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, Long> {

	@Query(value="select * from purchase_invoice", nativeQuery=true)
	List<PurchaseInvoice> getAllPurchaseInvoices(Pageable pageable);

	@Query(value="select * form purchase_invoice where store_id=?1", nativeQuery=true)
	List<PurchaseInvoice> getPurchaseInvoicesByStoreId(Long storeId, Pageable pageable);

	@Query(value="select * from purchase_invoice where id_purchase_invoice=?1", nativeQuery=true)
	PurchaseInvoice getPurchaseInvoicesById(Long idPurchaseInvoice);

	@Query(value="select * from purchase_invoice where vendor_id=?1", nativeQuery=true)
	List<PurchaseInvoice> getPurchaseInvoiceByVendorId(Long vendorId, Pageable pageable);

	@Query(value="select * from purchase_invoice where created_date in (fromDate, toDate)", nativeQuery=true)
	List<PurchaseInvoice> getBetweenPurchaseInvoice(Date fromDate, Date toDate, Pageable pageable);

}
