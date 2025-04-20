package com.example.demo.repositories;

import com.example.demo.models.Demographics;
import com.example.demo.models.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepository extends JpaRepository<Fee,Long> {
}
