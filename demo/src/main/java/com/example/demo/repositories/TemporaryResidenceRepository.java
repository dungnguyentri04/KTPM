package com.example.demo.repositories;

import com.example.demo.models.Demographics;
import com.example.demo.models.TemporaryResidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemporaryResidenceRepository extends JpaRepository<TemporaryResidence,Long> {
}
