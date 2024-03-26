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

import com.java.agrofund.model.LoanDetails;
import com.java.agrofund.service.LoanDetailsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("agrofund/api/v1/loandetails")
public class LoanDetailsController {
    private final LoanDetailsService loanDetailsService;

    @GetMapping
    public ResponseEntity<List<LoanDetails>> getAllLoanDetails(){
        List<LoanDetails> loanDetails = loanDetailsService.getAllLoanDeatils();
        return ResponseEntity.ok(loanDetails);
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<LoanDetails> getPlanById(@PathVariable String loanId){

        Optional<LoanDetails> loanDetails = loanDetailsService.getLoanDetailsById(loanId);
        return loanDetails.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<LoanDetails> createdLoanDetails(@RequestBody LoanDetails loandetails){
        LoanDetails createdLoanDetails = loanDetailsService.createdLoanDetails(loandetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLoanDetails);
    }

    @DeleteMapping("/{loanId}")
    public ResponseEntity<String> delete(@PathVariable String loanId){
        loanDetailsService.deleteLoanDetails(loanId);
        return ResponseEntity.ok("loan deleted successfully");
    }

    @PutMapping("/{loanId}")
    public ResponseEntity<LoanDetails> updateLoanDetails(@PathVariable String loanId, @RequestBody LoanDetails loanDetails){
        var updateLoanDetails = loanDetailsService.updateLoanDetails(loanId, loanDetails);
        return updateLoanDetails.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}
