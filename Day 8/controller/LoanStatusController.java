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

import com.java.agrofund.model.LoanStatus;
import com.java.agrofund.service.LoanStatusService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("agrofund/api/v1/loanstatus")
public class LoanStatusController {
    private final LoanStatusService loanStatusService;

    
    @GetMapping
    public ResponseEntity<List<LoanStatus>> getAllLoanStatus(){
        List<LoanStatus> loanStatus = loanStatusService.getAllLoanStatus();
        return ResponseEntity.ok(loanStatus);
    }

    @GetMapping("/{loansatus}")
    public ResponseEntity<LoanStatus> getLoanStatusById(@PathVariable String loanId){

        Optional<LoanStatus> loanStatus = loanStatusService.getLoanStatusById(loanId);
        return loanStatus.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<LoanStatus> createdLoanStatus(@RequestBody LoanStatus loanstatus){
        LoanStatus createLoanStatus = loanStatusService.createLoanStatus(loanstatus);
        return ResponseEntity.status(HttpStatus.CREATED).body(createLoanStatus);
    }

    @DeleteMapping("/{loanstatus}")
    public ResponseEntity<String> delete(@PathVariable String loanId){
        loanStatusService.deleteLoanStatus(loanId);
        return ResponseEntity.ok("loanstatus deleted successfully");
    }

    @PutMapping("/{loanstatus}")
    public ResponseEntity<LoanStatus> updateLoanStatus(@PathVariable String loanId, @RequestBody LoanStatus loanStatus){
        var updateLoanStatus = loanStatusService.updateLoanStatus(loanId, loanStatus);
        return updateLoanStatus.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    
}
