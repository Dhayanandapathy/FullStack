package com.java.agrofund.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.agrofund.model.LoanApproved;
import com.java.agrofund.service.LoanApprovedService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("agrofund/api/v1/loanapproved")
public class LoanApprovedController {
    private final LoanApprovedService loanApprovedService;

    @GetMapping
    public ResponseEntity<List<LoanApproved>> getAllLoanApproved(){
        List<LoanApproved> loanApproved = loanApprovedService.getAllLoanApproved();
        return ResponseEntity.ok(loanApproved);
    }

    @GetMapping("/{approvedloanId}")
    public ResponseEntity<LoanApproved> getLoanApprovedById(@PathVariable String loanId){
    Optional<LoanApproved> loanApproved = loanApprovedService.getLoanApprovedById(loanId);
        return loanApproved.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<LoanApproved> createLoanApproved(@RequestBody LoanApproved loanApproved){
        LoanApproved createLoanApproved = loanApprovedService.creatLoanApproved(loanApproved);
        return ResponseEntity.status(HttpStatus.CREATED).body(createLoanApproved);
    }

    @DeleteMapping("/{loanapprovedId}")
    public ResponseEntity<String> delete(@PathVariable String loanId){
        loanApprovedService.deleteLoanApproved(loanId);
        return ResponseEntity.ok("loanapproved deleted successfully");
    }

    @PutMapping("/{loanapprovedId}")
    public ResponseEntity<LoanApproved> updateLoanApproved(@PathVariable String loanId, @RequestBody LoanApproved loanApproved){
        var updateLoanApproved = loanApprovedService.updateLoanApproved(loanId, loanApproved);
        return updateLoanApproved.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}
