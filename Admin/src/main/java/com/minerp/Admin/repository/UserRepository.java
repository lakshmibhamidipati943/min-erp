package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.username=?1 ")
	User findByUsername(String username);
	
	

	@Query(value="select * from users where status=?1",nativeQuery=true)
	List<User> getActiveOrInactiveUsers(@Param("status")Boolean status, Pageable pageable);



	boolean existsByUsername(String username);

	

}
