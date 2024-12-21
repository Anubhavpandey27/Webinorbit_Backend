package com.webinorbit.security.Startup;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Startup {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startupName;

    private String businessType;

    private String companyIdentificationNumber;

    private String dateOfIncorporation;

    private String registeredOfficeAddress;

    private String email;

    private String phoneNumber;

    private String gstin;

    private String bankAccountDetails; // You can save as a JSON or simple string IFSC: XXXXX, Account No: XXXXX

    private String website;

    private String servicesOrProductsOffered;

    private String kycDocuments; // Paths to Aadhar, PAN files or a JSON if multiple files

}
