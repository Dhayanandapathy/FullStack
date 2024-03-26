package com.java.agrofund.service;

import java.util.List;
import java.util.Optional;

import com.java.agrofund.model.LoanDetails;

public interface LoanDetailsService {
    List<LoanDetails> getAllLoanDeatils();
    Optional<LoanDetails> getLoanDetailsById(String loanId);
    LoanDetails createdLoanDetails(LoanDetails loandetails);
    Optional<LoanDetails> updateLoanDetails(String loanId, LoanDetails loandetails);
    void deleteLoanDetails(String loanId);
    
}
