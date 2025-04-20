package com.example.demo.repositories;

import com.example.demo.models.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributionRepository extends JpaRepository<Contribution,Long> {
}
