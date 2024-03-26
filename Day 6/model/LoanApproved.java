package com.java.agrofund.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="LoanApproved")
@Entity
public class LoanApproved {
     @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String ApplicantName;
    private String ApplicantAadhar;
    private String Applicantmobile;
    private String ApplicantLoanNeed;
    private String LoanAmoumt;
}
