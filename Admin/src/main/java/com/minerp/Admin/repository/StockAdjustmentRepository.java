package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.StockAdjustment;

@Repository
public interface StockAdjustmentRepository extends JpaRepository<StockAdjustment, Long>{

}
