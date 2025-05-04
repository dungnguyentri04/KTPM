package com.example.demo.service.helper;

import com.example.demo.models.Fee;
import com.example.demo.models.Household;
import com.example.demo.repositories.FeeRepository;

import java.util.Map;

public class EletricityFeeCaculator implements FeeCaculator {
    @Override
    public double calculateFee(Household household, Fee fee, Map<String, Object> attributes) {
        return 0;
    }
}
