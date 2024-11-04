package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.UOM;

@Repository
public interface UOMRepository extends JpaRepository<UOM, Long>{

	@Query(value="select * from uom",nativeQuery=true )
	List<UOM> getAllUOMs(Pageable pageable);

	@Query(value="select * from uom where id_uom=?1", nativeQuery=true)
	UOM getUOMById(Long idUom);

}
