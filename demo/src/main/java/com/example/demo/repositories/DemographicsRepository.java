package com.example.demo.repositories;

import com.example.demo.models.Demographics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemographicsRepository extends JpaRepository<Demographics,Long> {
    public List<Demographics> findByHouseholdId(Long id);

    public Demographics findByCitizenId(String citizenId);

    public Demographics findByEmail(String email);
}
