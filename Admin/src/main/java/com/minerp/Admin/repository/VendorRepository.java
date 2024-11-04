package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

	@Query(value="select * from vendor where id_vendor=?1", nativeQuery=true)
	Vendor getVendorById(Long idVendor);

	@Query(value="select * from vendor", nativeQuery=true)
	List<Vendor> getAllVendors(Pageable pageable);

}
