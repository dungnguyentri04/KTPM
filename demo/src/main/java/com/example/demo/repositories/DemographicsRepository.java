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

    @Query(value = "SELECT COUNT(*) FROM demographics WHERE gender = 'MALE'", nativeQuery = true)
    public long countMaleDemographics();

    @Query(value = "SELECT COUNT(*) FROM demographics WHERE gender = 'FEMALE'", nativeQuery = true)
    public long countFemaleDemographics();

    @Query(value = "SELECT COUNT(*) FROM demographics WHERE status = 'ACTIVE'", nativeQuery = true)
    public long countActiveDemographics();

    @Query(value = "SELECT COUNT(*) FROM demographics WHERE status = 'INACTIVE'", nativeQuery = true)
    public long countInactiveDemographics();

    @Query(value = "SELECT COUNT(*) FROM demographics WHERE status = 'DELETED'", nativeQuery = true)
    public long countDeletedDemographics();

    @Query(value = "SELECT COUNT(*) FROM demographics WHERE status = 'PENDING'", nativeQuery = true)
    public long countPendingDemographics();

    @Query(value = "SELECT COUNT(*) FROM demographics WHERE status = 'VERIFIED'", nativeQuery = true)
    public long countVerifiedDemographics();

    @Query(value = "SELECT COUNT(*) FROM demographics WHERE status = 'UNVERIFIED'", nativeQuery = true)
    public long countUnverifiedDemographics();
}
