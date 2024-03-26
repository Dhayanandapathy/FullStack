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

import com.java.agrofund.model.AppliedLoan;
import com.java.agrofund.service.AppliedLoanSerrvice;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("agrofund/api/v1/appliedloan")
public class AppliedLoanController {

    private final AppliedLoanSerrvice appliedLoanSerrvice;

    @GetMapping
    public ResponseEntity<List<AppliedLoan>> getAllAppliedLoan(){
        List<AppliedLoan> apploan = appliedLoanSerrvice.getAllAppliedLoans();
        return ResponseEntity.ok(apploan);
    }

    @GetMapping("/{apploanId}")
    public ResponseEntity<AppliedLoan> getAppliedLoanById(@PathVariable String loanId){

        Optional<AppliedLoan> appliedLoan = appliedLoanSerrvice.getAppliedLoanById(loanId);
        return appliedLoan.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<AppliedLoan> createPLan(@RequestBody AppliedLoan appliedLoan){
        AppliedLoan createAppliedLoan = appliedLoanSerrvice.createAppliedLoan(appliedLoan);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAppliedLoan);
    }

    @DeleteMapping("/{apploanId}")
    public ResponseEntity<String> delete(@PathVariable String loanId){
        appliedLoanSerrvice.deleteAppliedLoan(loanId);
        return ResponseEntity.ok("appliedloan deleted successfully");
    }

    @PutMapping("/{apploanId}")
    public ResponseEntity<AppliedLoan> updateAppliedLoan(@PathVariable String loanId, @RequestBody AppliedLoan appliedLoan){
        var updateAppliedloan = appliedLoanSerrvice.updateAppliedLoan(loanId, appliedLoan);
        return updateAppliedloan.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
}
