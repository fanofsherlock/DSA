package com.nissan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.service.OrchestratorService;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

    @Autowired
    OrchestratorService service;

    @GetMapping("/available")
    public String availableBots(){
        return service.getAvailableBots();
    }

}
