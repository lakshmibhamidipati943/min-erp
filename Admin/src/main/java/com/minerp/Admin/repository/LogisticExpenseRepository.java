package com.minerp.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.LogisticExpense;

@Repository
public interface LogisticExpenseRepository extends JpaRepository<LogisticExpense, Long>{

}
