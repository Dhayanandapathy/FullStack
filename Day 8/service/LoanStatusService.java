package com.java.agrofund.service;

import java.util.List;
import java.util.Optional;

import com.java.agrofund.model.LoanStatus;

public interface LoanStatusService {

    List<LoanStatus> getAllLoanStatus();
    Optional<LoanStatus> getLoanStatusById(String loanId);
    LoanStatus createLoanStatus(LoanStatus loanStatus);
    Optional<LoanStatus> updateLoanStatus(String loanId, LoanStatus loanStatus);
    void deleteLoanStatus(String loanId);
    
}
