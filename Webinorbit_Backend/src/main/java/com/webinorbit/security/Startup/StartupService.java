package com.webinorbit.security.Startup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final StartupRepository startupRepository;

    // AtomicLong for generating unique IDs manually
    private final AtomicLong counter = new AtomicLong(1);

    public void registerStartup(Startup startup) {
        if (startupRepository.findByEmail(startup.getEmail()).isPresent()) {
            throw new RuntimeException("A startup with this email is already registered");
        }
        if (startupRepository.findByCompanyIdentificationNumber(startup.getCompanyIdentificationNumber()).isPresent()) {
            throw new RuntimeException("A startup with this Company Identification Number (CIN) is already registered");
        }
        startup.setId(counter.getAndIncrement()); // Manually assign a unique ID
        startupRepository.save(startup);
    }

    public List<Startup> getAllStartups() {
        return startupRepository.findAll();
    }

    public Startup getStartupById(Long startupId) {
        return startupRepository.findById(startupId)
                .orElseThrow(() -> new RuntimeException("Startup not found with ID: " + startupId));
    }

    public void updateStartup(Long startupId, Startup updatedStartup) {
        Startup existingStartup = startupRepository.findById(startupId)
                .orElseThrow(() -> new RuntimeException("Startup not found with ID: " + startupId));

        existingStartup.setStartupName(updatedStartup.getStartupName());
        existingStartup.setBusinessType(updatedStartup.getBusinessType());
        existingStartup.setCompanyIdentificationNumber(updatedStartup.getCompanyIdentificationNumber());
        existingStartup.setDateOfIncorporation(updatedStartup.getDateOfIncorporation());
        existingStartup.setRegisteredOfficeAddress(updatedStartup.getRegisteredOfficeAddress());
        existingStartup.setEmail(updatedStartup.getEmail());
        existingStartup.setPhoneNumber(updatedStartup.getPhoneNumber());
        existingStartup.setGstin(updatedStartup.getGstin());
        existingStartup.setBankAccountDetails(updatedStartup.getBankAccountDetails());
        existingStartup.setWebsite(updatedStartup.getWebsite());
        existingStartup.setServicesOrProductsOffered(updatedStartup.getServicesOrProductsOffered());
        existingStartup.setKycDocuments(updatedStartup.getKycDocuments());

        startupRepository.save(existingStartup);
    }

    public void deleteStartup(Long startupId) {
        Startup existingStartup = startupRepository.findById(startupId)
                .orElseThrow(() -> new RuntimeException("Startup not found with ID: " + startupId));

        startupRepository.delete(existingStartup);
    }
}
