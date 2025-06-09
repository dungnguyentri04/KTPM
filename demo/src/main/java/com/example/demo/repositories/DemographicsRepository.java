package com.example.demo.repositories;

import com.example.demo.models.Demographics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DemographicsRepository extends JpaRepository<Demographics,Long> {
    public List<Demographics> findByHouseholdId(Long id);

    public Demographics findByCitizenId(String citizenId);

    public Demographics findByEmail(String email);

    @Query(value = "SELECT COUNT(*) FROM demographics", nativeQuery = true)
    public long countTotalDemographics();
}
