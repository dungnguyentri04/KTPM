package com.example.demo.controllers;

import com.example.demo.service.TemporaryResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class TemporaryResidenceController {
    @Autowired
    private TemporaryResidenceService temporaryResidenceService;

}
