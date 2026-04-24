package com.example.assignment2.service;

import com.example.assignment2.entity.Score;
import com.example.assignment2.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service   // ✅ VERY IMPORTANT
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public String addScore(Long userId, int score, LocalDate date) {

        if (scoreRepository.existsByUserIdAndPlayedAt(userId, date)) {
            return "Duplicate date not allowed";
        }

        List<Score> scores = scoreRepository.findByUserIdOrderByPlayedAtAsc(userId);

        if (scores.size() >= 5) {
            scoreRepository.delete(scores.get(0));
        }

        Score newScore = new Score();
        newScore.setUserId(userId);
        newScore.setScore(score);
        newScore.setPlayedAt(date);

        scoreRepository.save(newScore);

        return "Score added";
    }

    public List<Score> getScores(Long userId) {
        return scoreRepository.findByUserIdOrderByPlayedAtAsc(userId);
    }
}