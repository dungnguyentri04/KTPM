package com.example.demo.controllers;

import com.example.demo.repositories.HouseholdRepository;
import com.example.demo.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class HouseHoldController {
    @Autowired
    private HouseholdService householdService;

    @GetMapping("/households")
    public String getAllHouseholds(){
        return null;
    }

    @GetMapping("/households/{householdId}")
    public String getHousehold(){
        return null;
    }

    @PostMapping("/households")
    public String addHousehold(){
        return null;
    }

    @DeleteMapping("/households/{householdId}")
    public String deleteHousehold(){
        return null;
    }

    @PutMapping("/households/{householdId}")
    public String updateHousehold(){
        return null;
    }

    //get tuỳ chỉnh với các tham số

}
