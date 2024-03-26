package com.java.agrofund.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.agrofund.model.LoanApproved;

@Repository
public interface LoanApprovedRepository extends JpaRepository<LoanApproved,String>{
    
}
