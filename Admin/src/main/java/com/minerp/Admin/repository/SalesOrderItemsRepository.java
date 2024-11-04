package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.SalesOrderItems;

@Repository
public interface SalesOrderItemsRepository extends JpaRepository<SalesOrderItems, Long>{

}
