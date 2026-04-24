package com.example.assignment2.repository;

import com.example.assignment2.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    // Get all scores for a user sorted by date (oldest first)
    List<Score> findByUserIdOrderByPlayedAtAsc(Long userId);

    // Check if score already exists for a specific date
    boolean existsByUserIdAndPlayedAt(Long userId, LocalDate playedAt);
}