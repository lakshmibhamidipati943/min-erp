package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.DeliveryNotes;

@Repository
public interface DeliveryNotesRepository extends JpaRepository<DeliveryNotes, Long>{

}
