package com.example.assignment2.service;

import com.example.assignment2.entity.Draw;
import com.example.assignment2.entity.Score;
import com.example.assignment2.entity.Winner;
import com.example.assignment2.repository.DrawRepository;
import com.example.assignment2.repository.ScoreRepository;
import com.example.assignment2.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DrawService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private DrawRepository drawRepository;

    @Autowired
    private WinnerRepository winnerRepository;

    public Map<String, Object> runDraw() {

        // ✅ FIXED DRAW NUMBERS (FOR TESTING)
        List<Integer> drawNumbers = Arrays.asList(1, 2, 3, 4, 5);

        // 💾 Save draw in DB
        Draw draw = new Draw();
        draw.setNumbers(drawNumbers.toString());
        drawRepository.save(draw);

        // 📊 Get all scores
        List<Score> scores = scoreRepository.findAll();

        // 🧠 Group scores by user
        Map<Long, List<Integer>> userScores = new HashMap<>();

        for (Score s : scores) {
            userScores
                    .computeIfAbsent(s.getUserId(), k -> new ArrayList<>())
                    .add(s.getScore());
        }

        List<Winner> winners = new ArrayList<>();

        // 🎯 Check matches per user
        for (Map.Entry<Long, List<Integer>> entry : userScores.entrySet()) {

            Long userId = entry.getKey();
            List<Integer> scoresList = entry.getValue();

            int matchCount = 0;

            for (Integer s : scoresList) {
                if (drawNumbers.contains(s)) {
                    matchCount++;
                }
            }

            // ✅ Apply winning rule (>=3 matches)
            if (matchCount >= 3) {

                Winner w = new Winner();
                w.setUserId(userId);
                w.setMatchCount(matchCount);

                // 💰 Prize logic
                if (matchCount == 3) {
                    w.setPrize(100);
                } else if (matchCount == 4) {
                    w.setPrize(500);
                } else if (matchCount == 5) {
                    w.setPrize(1000);
                }

                w.setStatus("PENDING");

                winnerRepository.save(w);
                winners.add(w);
            }
        }

        // 📤 Response
        Map<String, Object> result = new HashMap<>();
        result.put("drawNumbers", drawNumbers);
        result.put("winners", winners);

        return result;
    }
}