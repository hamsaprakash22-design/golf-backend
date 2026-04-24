package com.example.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment2.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{

}
