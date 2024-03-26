package com.java.agrofund.service;

import java.util.List;
import java.util.Optional;

import com.java.agrofund.model.LoanApproved;

public interface LoanApprovedService {

    List<LoanApproved> getAllLoanApproved();
    Optional<LoanApproved> getLoanApprovedById(String loanId);
    LoanApproved creatLoanApproved(LoanApproved loanApproved);
    Optional<LoanApproved> updateLoanApproved(String loanId, LoanApproved loanApproved);
    void deleteLoanApproved(String loanId);
    
}
