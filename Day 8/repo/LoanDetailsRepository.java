package com.java.agrofund.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.agrofund.model.LoanDetails;

public interface LoanDetailsRepository extends JpaRepository<LoanDetails, String>{
    
}
