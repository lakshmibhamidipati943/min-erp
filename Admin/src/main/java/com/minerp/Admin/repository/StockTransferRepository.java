package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.StockTransfer;

@Repository
public interface StockTransferRepository extends JpaRepository<StockTransfer, Long>{

}
