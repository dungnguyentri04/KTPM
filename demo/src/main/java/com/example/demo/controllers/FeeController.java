package com.example.demo.controllers;

import com.example.demo.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class FeeController {
    @Autowired
    private FeeService feeService;

    @GetMapping("/fees")
    public String getAllFees(){
        return null;
    }

    @GetMapping("/fees/{feeId}")
    public String getFee(){
        return null;
    }

    @PostMapping("/fees")
    public String addFee(){
        return null;
    }

    @DeleteMapping("/fees/{feeId}")
    public String deleteFee(){
        return null;
    }

    @PutMapping("/fees/{feeId}")
    public String updateFee(){
        return null;
    }
}
