package com.example.assignment2.controller;

import com.example.assignment2.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    // ✅ Add Score (using GET for easy browser testing)
    @GetMapping("/add")
    public String addScore(
            @RequestParam Long userId,
            @RequestParam int score,
            @RequestParam String date
    ) {
        return scoreService.addScore(userId, score, LocalDate.parse(date));
    }

    // ✅ Get Scores
    @GetMapping
    public Object getScores(@RequestParam Long userId) {
        return scoreService.getScores(userId);
    }
}