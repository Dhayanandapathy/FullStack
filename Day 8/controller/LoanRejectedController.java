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
import com.java.agrofund.model.LoanRejected;
import com.java.agrofund.service.LoanDetailsService;
import com.java.agrofund.service.LoanRejectedService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("agrofund/api/v1/loanrejected")
public class LoanRejectedController {

    private final LoanRejectedService loanRejectedService;

    @GetMapping
    public ResponseEntity<List<LoanRejected>> getAllLoanRejected(){
        List<LoanRejected> loanRejected = loanRejectedService.getAllLoanRejected();
        return ResponseEntity.ok(loanRejected);
    }

    @GetMapping("/{loanrejectedId}")
    public ResponseEntity<LoanRejected> getLoanRejectedById(@PathVariable String loanId){

        Optional<LoanRejected> loanRejected = loanRejectedService.getLoanRejectedById(loanId);
        return loanRejected.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<LoanRejected> createdLoanRejected(@RequestBody LoanRejected loanRejected){
        LoanRejected createLoanRejected = loanRejectedService.createLoanRejected(loanRejected);
        return ResponseEntity.status(HttpStatus.CREATED).body(createLoanRejected);
    }

    @DeleteMapping("/{loanrejectId}")
    public ResponseEntity<String> delete(@PathVariable String loanId){
        loanRejectedService.deleteLoanRejected(loanId);
        return ResponseEntity.ok("loan rejected successfully");
    }

    @PutMapping("/{loanrejectId}")
    public ResponseEntity<LoanRejected> updateLoanRejected(@PathVariable String loanId, @RequestBody LoanRejected loanRejected){
        var updateLoanRejected = loanRejectedService.updateLoanRejected(loanId, loanRejected);
        return updateLoanRejected.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
}
