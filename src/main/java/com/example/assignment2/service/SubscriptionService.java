package com.example.assignment2.service;

import com.example.assignment2.entity.Subscription;
import com.example.assignment2.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public String subscribe(Long userId, String plan) {

        Subscription s = new Subscription();
        s.setUserId(userId);
        s.setPlan(plan);
        s.setStatus("ACTIVE");
        s.setRenewalDate(LocalDate.now().plusMonths(1));

        subscriptionRepository.save(s);

        return "Subscription activated";
    }
}