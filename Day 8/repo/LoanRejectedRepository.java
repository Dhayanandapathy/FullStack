package com.java.agrofund.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.agrofund.model.LoanRejected;

@Repository
public interface LoanRejectedRepository extends JpaRepository<LoanRejected,String> {
    
}
