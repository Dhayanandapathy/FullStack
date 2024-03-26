package com.java.agrofund.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.agrofund.model.LoanStatus;

@Repository
public interface LoanStatusRepository extends JpaRepository<LoanStatus,String>{
    
}
