package com.example.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment2.entity.Charity;

public interface CharityRepository  extends JpaRepository<Charity, Long>{

}
