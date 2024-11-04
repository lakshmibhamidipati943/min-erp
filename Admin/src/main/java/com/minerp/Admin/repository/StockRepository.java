package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	@Query(value="select * from stock where item_id=?1",nativeQuery=true)
	List<Stock> getStockByItemId(Long itemId, Pageable pageable);

	@Query(value="select * from stock where item_id=?1 and store_id=?2",nativeQuery=true)
	List<Stock> getStockByItemIdAndStoreId(Long itemId, Long storeId, Pageable pageable);

	@Query(value="select * from stock", nativeQuery=true)
	List<Stock> getAllStock(Pageable pageable);

	@Query(value="select * from stock where store_id=?1",nativeQuery=true)
	List<Stock> getStockByStoreId(Long storeId, Pageable pageable);

}
