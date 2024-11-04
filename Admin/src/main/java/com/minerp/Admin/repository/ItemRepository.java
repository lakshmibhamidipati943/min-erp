package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	@Query(value="select * from item where id_item=?1", nativeQuery=true)
	Item getItemById(Long idItem);

	@Query(value="select i.* from item i JOIN vendor_item vi ON i.id_item=vi.item_id where vi.vendor_id=?1", nativeQuery=true)
	List<Item> getItemsByVendorId(Long vendorId, Pageable pageable);

	@Query(value="select * from item", nativeQuery=true)
	List<Item> getAllItems(Pageable pageable);

}
