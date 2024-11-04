package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

	@Query(value="select * from country where id_country=?1",nativeQuery=true)
	Country getCountryById(Long id);

	@Query(value="select * from country where country_name=?1", nativeQuery=true)
	Boolean existsByCountryname(String countryName);

}
