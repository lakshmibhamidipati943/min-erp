package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.SalesInvoice;

@Repository
public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, Long>{

}
