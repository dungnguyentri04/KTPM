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

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'IN_PROGRESS'", nativeQuery = true)
    public long countHouseholdsWithInProgressContribution();

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'PAID'", nativeQuery = true)
    public long countHouseholdsWithPaidContribution();

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'OVERDUE'", nativeQuery = true)
    public long countHouseholdsWithOverdueContribution();

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'CANCELLED'", nativeQuery = true)
    public long countHouseholdsWithCancelledContribution();

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'PENDING'", nativeQuery = true)
    public long countHouseholdsWithPendingContribution();

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'REJECTED'", nativeQuery = true)
    public long countHouseholdsWithRejectedContribution();

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'EXPIRED'", nativeQuery = true)
    public long countHouseholdsWithExpiredContribution();

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'UNPAID'", nativeQuery = true)
    public long countHouseholdsWithUnpaidContribution();

    @Query(value = "SELECT COUNT(DISTINCT household_id) FROM contribution WHERE status = 'REFUNDED'", nativeQuery = true)
    public long countHouseholdsWithRefundedContribution();
}
