package com.example.assignment2.controller;

import com.example.assignment2.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/winners")
@CrossOrigin
public class WinnerController {

    @Autowired
    private WinnerService winnerService;

    @GetMapping
    public Object getWinners() {
        return winnerService.getAllWinners();
    }

    @GetMapping("/pay")
    public String pay(@RequestParam Long winnerId) {
        return winnerService.markPaid(winnerId);
    }
}