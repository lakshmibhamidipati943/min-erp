package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.VendorItem;

@Repository
public interface VendorItemRepository extends JpaRepository<VendorItem, Long>{

	@Query(value="select * from vendor_items where vendor_id=?1", nativeQuery=true)
	List<VendorItem> getVendorItemsByVendorId(Long idVendor, Pageable pageable);

	@Query(value="select * from vendor_items", nativeQuery=true)
	List<VendorItem> getAllVendorItems(Pageable pageable);

}
