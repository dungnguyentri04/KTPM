package com.example.demo.controllers;

import com.example.demo.service.DemographicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class DemographicController {
    @Autowired
    private DemographicService demographicService;

    @GetMapping("/demographics")
    public String getAllDemographics(){
        return null;
    }

    @GetMapping("/demographics/{demographicId}")
    public String getDemographic(){
        return null;
    }

    @PostMapping("/demographics")
    public String addDemographic(){
        return null;
    }

    @DeleteMapping("/demographics/{demographicId}")
    public String deleteDemographic(){
        return null;
    }

    @PutMapping("/demographics/{demographicId}")
    public String updateDemographic(){
        return null;
    }

    //xem lai cach tao api
    @GetMapping("/demographics/households/{househouldId}")
    public String getHouseholdDemographics(){
        return null;
    }


    //Get query parameter tuỳ chỉnh với các tham số
}
