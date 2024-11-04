package com.minerp.Admin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.GoodsReceivedNotes;

@Repository
public interface GoodsReceivedNotesRepository extends JpaRepository<GoodsReceivedNotes, Long>{

	@Query(value="select * from goods_received_notes", nativeQuery=true)
	List<GoodsReceivedNotes> getAllGoodsReceivedNotes(Pageable pageable);

	@Query(value="select * from goods_received_notes where id_goods_received_notes", nativeQuery=true)
	GoodsReceivedNotes getAllGoodsReceivedNotes(Long idGoodsReceivedNotes);

	@Query(value="select * from goods_received_notes where created_date in (fromDate, toDate)", nativeQuery=true)
	List<GoodsReceivedNotes> getBetweenGoodsReceivedNotes(Date fromDate, Date toDate, Pageable pageable);

	@Query(value="select * from goods_received_notes where store_id=?1", nativeQuery=true)
	List<GoodsReceivedNotes> getGoodsReceivedNotesByStoreId(Long storeId, Pageable pageable);

	@Query(value="select * from goods_received_notes where vendor_id=?1", nativeQuery=true)
	List<GoodsReceivedNotes> getGoodsReceivedNotesByVendorId(Long vendorId, Pageable pageable);

}
