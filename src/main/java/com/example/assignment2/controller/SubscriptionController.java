package com.example.assignment2.controller;

import com.example.assignment2.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
@CrossOrigin
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/subscribe")
    public String subscribe(
            @RequestParam Long userId,
            @RequestParam String plan
    ) {
        return subscriptionService.subscribe(userId, plan);
    }
}