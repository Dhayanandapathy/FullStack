package com.java.agrofund.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.agrofund.model.AppliedLoan;

@Repository
public interface AppliedLoanRepository extends JpaRepository<AppliedLoan,String> {
    
}
