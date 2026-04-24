package com.example.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment2.entity.Winner;

public interface WinnerRepository  extends JpaRepository<Winner, Long>{

}
