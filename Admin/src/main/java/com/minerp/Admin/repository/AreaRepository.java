package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long>{

	@Query(value="select * from area where id_area=?1", nativeQuery=true)
	Area getAreaById(Long id);

	@Query(value="select * from area", nativeQuery=true)
	List<Area> getAllAreas(Pageable pageable);

	@Query(value="select * from area where city_id=?1", nativeQuery=true)
	List<Area> getAreasByCityId(Long id, Pageable pageable);

}
