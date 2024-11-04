package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.SalesOrderAddress;

@Repository
public interface SalesOrderAddressRepository extends JpaRepository<SalesOrderAddress, Long>{

}
