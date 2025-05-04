package com.example.demo.service.helper;

import com.example.demo.models.Fee;
import com.example.demo.models.Household;

import java.util.Map;

public class VoluntaryFeeCaculator implements FeeCaculator{
    @Override
    public double calculateFee(Household household, Fee fee, Map<String, Object> attributes) {
        return 0;
    }
}
