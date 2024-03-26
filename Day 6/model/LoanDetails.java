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
@Table(name="LoanDetails")
@Entity
public class LoanDetails {  
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String ApplicantName;
    private String ApplicantEmail;
    private String ApplicantAadhar;
    private String ApplicantSalary;
    private String ApplicantAddress;
    private String ApplicantMobile;
    private String ApplicantPanNo;
    private String Repaymentmonths;
    
}
