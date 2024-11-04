package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.DeliveryNotesItems;

@Repository
public interface DeliveryNotesItemsRepository extends JpaRepository<DeliveryNotesItems, Long>{

}
