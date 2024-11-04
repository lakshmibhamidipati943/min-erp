package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.PaymentMode;

@Repository
public interface PaymentModeRepository extends JpaRepository<PaymentMode, Long>{

	@Query(value="select * from payment_mode",nativeQuery=true)
	List<PaymentMode> getAllPaymentModes(Pageable pageable);

}
