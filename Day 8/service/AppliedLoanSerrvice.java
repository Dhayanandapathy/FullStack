package com.java.agrofund.service;

import java.util.List;
import java.util.Optional;

import com.java.agrofund.model.AppliedLoan;

public interface AppliedLoanSerrvice {

    List<AppliedLoan> getAllAppliedLoans();
    Optional<AppliedLoan> getAppliedLoanById(String loanId);
    AppliedLoan createAppliedLoan(AppliedLoan appliedLoan);
    Optional<AppliedLoan> updateAppliedLoan(String loanId, AppliedLoan appliedLoan);
    void deleteAppliedLoan(String loanId);

    
}
