package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.VendorPayment;

@Repository
public interface VendorPaymentRepository extends JpaRepository<VendorPayment, Long>{

	@Query(value="select * from vendor_payment", nativeQuery=true)
	List<VendorPayment> getVendorPayments(Pageable pageable);

	@Query(value="select * from vendor_payment where id_vendor_payment=?1", nativeQuery=true)
	VendorPayment getVendorPaymentById(Long idVendorPayment);

	@Query(value="select * from vendor_payment where invoice_id=?1", nativeQuery=true)
	List<VendorPayment> getVendorPaymentByInvoiceId(Long invoiceId, Pageable pageable);

}
