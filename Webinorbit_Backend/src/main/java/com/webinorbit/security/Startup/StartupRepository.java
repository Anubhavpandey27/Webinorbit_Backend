package com.webinorbit.security.Startup;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StartupRepository extends JpaRepository<Startup, Long> {

    Optional<Startup> findByEmail(String email); // Find by email (can be used to check if startup is already registered)

    Optional<Startup> findByCompanyIdentificationNumber(String cin); // To verify company by CIN

    @Override
    <S extends Startup> S save(S entity);
}
