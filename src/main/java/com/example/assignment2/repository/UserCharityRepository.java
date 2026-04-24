package com.example.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment2.entity.UserCharity;

public interface UserCharityRepository extends JpaRepository<UserCharity, Long> {

}
