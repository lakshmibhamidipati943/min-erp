package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

	@Query(value="select * from state where country_id=?1",nativeQuery=true)
	List<State> getStatesByCountryId(Long id, Pageable pageable);

	@Query(value="select * from state where id_state=?1", nativeQuery=true)
	State getStatesByStateId(Long id);

	@Query(value="select * from state",nativeQuery=true)
	List<State> getAllStates(Pageable pageable);

}
