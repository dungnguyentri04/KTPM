package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("/viewDemographic")
    public String viewDemographic(@RequestParam("id") Long id) {
        return "viewDemographic";
    }

    @GetMapping("/viewAllUsers")
    public String viewAllUsers() {
        return "viewAllUsers";
    }

    @GetMapping("/viewHousehold")
    public String viewHousehold(@RequestParam("id") Long id) {
        return "viewHousehold";
    }

    @GetMapping("/viewAllDemographics")
    public String viewAllDemographics() {
        return "viewAllDemographics";
    }

    @GetMapping("/addDemographic")
    public String addDemographic() {
        return "addDemographic";
    }

    @GetMapping("/addHousehold")
    public String addHousehold() {
        return "addHousehold";
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "addUser";
    }

    @GetMapping("/viewAllHouseholds")
    public String viewAllHouseholds() {
        return "viewAllHouseholds";
    }

    @GetMapping("/addFee")
    public String addFee() {
        return "addFee";
    }

    @GetMapping("/viewAllFees")
    public String viewAllFees() {
        return "viewAllFees";
    }

    @GetMapping("/addContribution")
    public String addContribution(@RequestParam("householdId") Long householdId) {
        return "addContribution";
    }

    @GetMapping("/dashboard")
    public String test() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/viewAllRooms")
    public String allRooms() {
        return "viewAllRoom";
    }

    @GetMapping("/addRoom")
    public String addRoom() {
        return "addRoom";
    }

    @GetMapping("/addTemporary")
    public String addTemporary(@RequestParam(value = "type", defaultValue = "default") String type,
                               @RequestParam(value = "demographicId", defaultValue = "0") Long demographicId) {
        return "addTemporary";
    }

    @GetMapping("/viewAllTemporary")
    public String viewAllTemporary() {
        return "viewAllTemporary";
    }

}
