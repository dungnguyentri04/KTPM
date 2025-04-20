package com.example.demo.repositories;

import com.example.demo.models.Demographics;
import com.example.demo.models.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household,Long> {
}
