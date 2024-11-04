package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query(value="select * from customer where id_customer=?1", nativeQuery=true)
	Customer getCustomerById(Long idCustomer);

}
