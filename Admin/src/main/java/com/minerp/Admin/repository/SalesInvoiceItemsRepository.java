package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.SalesInvoiceItems;

@Repository
public interface SalesInvoiceItemsRepository extends JpaRepository<SalesInvoiceItems, Long>{

	
}
