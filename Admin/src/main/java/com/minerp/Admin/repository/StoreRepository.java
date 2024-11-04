package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

	@Query(value="select * from store where id_store=?1", nativeQuery=true)
	Store getStoreById(Long id);

	@Query(value="select * from store",nativeQuery=true)
	List<Store> getAllStores(Pageable pageable);

	@Query(value="select * from store where pincode=?1",nativeQuery=true)
	List<Store> getStoresByPincode(String pincode, Pageable pageable);

	@Query(value="select * from store where area_id=?1", nativeQuery=true)
	List<Store> getStoresByAreaId(Long id, Pageable pageable);

}
