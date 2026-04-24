package com.example.assignment2.service;

import com.example.assignment2.entity.Winner;
import com.example.assignment2.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinnerService {

    @Autowired
    private WinnerRepository winnerRepository;

    public List<Winner> getAllWinners() {
        return winnerRepository.findAll();
    }

    public String markPaid(Long winnerId) {
        Winner w = winnerRepository.findById(winnerId).orElseThrow();
        w.setStatus("PAID");
        winnerRepository.save(w);
        return "Marked as paid";
    }
}
