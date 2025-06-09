package com.example.demo.repositories;

import com.example.demo.models.Demographics;
import com.example.demo.models.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseholdRepository extends JpaRepository<Household,Long> {
    @Query(value = "SELECT COUNT(*) FROM household", nativeQuery = true)
    public long countTotalHouseholds();
}
