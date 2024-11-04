package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.DeliveryCharges;

@Repository
public interface DeliveryChargesRepository extends JpaRepository<DeliveryCharges, Long>{

}
