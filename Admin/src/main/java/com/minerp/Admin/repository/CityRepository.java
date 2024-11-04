package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	@Query(value="select * from city where id_city=?1", nativeQuery=true)
	City getCityById(Long id);

	@Query(value="select * from city", nativeQuery=true)
	List<City> getAllCities(Pageable pageable);

    @Query(value="select * from city where state_id=?1", nativeQuery=true)
	List<City> getCityByStateId(Long id, Pageable pageable);

}
