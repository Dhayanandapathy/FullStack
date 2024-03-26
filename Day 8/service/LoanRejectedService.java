package com.java.agrofund.service;

import java.util.List;
import java.util.Optional;

import com.java.agrofund.model.LoanRejected;

public interface LoanRejectedService {
    List<LoanRejected> getAllLoanRejected();
    Optional<LoanRejected> getLoanRejectedById(String loanId);
    LoanRejected createLoanRejected(LoanRejected loanRejected);
    Optional<LoanRejected> updateLoanRejected(String loanId, LoanRejected loanRejected);
    void deleteLoanRejected(String loanId);
    
}
