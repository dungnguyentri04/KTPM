package com.example.demo.repositories;

import com.example.demo.models.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContributionRepository extends JpaRepository<Contribution,Long> {
    public List<Contribution> findByHouseholdId(Long id);

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'IN_COMPLETE'", nativeQuery = true)
    public long countHouseholdsWithIncompleteContribution();

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'COMPLETE'", nativeQuery = true)
    public long countHouseholdsWithCompleteContribution();
}
