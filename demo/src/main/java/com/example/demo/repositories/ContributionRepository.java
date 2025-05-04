package com.example.demo.repositories;

import com.example.demo.models.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContributionRepository extends JpaRepository<Contribution,Long> {
    public List<Contribution> findByHouseholdId(Long id);
}
