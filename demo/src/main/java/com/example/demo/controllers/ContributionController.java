package com.example.demo.controllers;

import com.example.demo.service.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class ContributionController {
    @Autowired
    private ContributionService contributionService;

    //
}
