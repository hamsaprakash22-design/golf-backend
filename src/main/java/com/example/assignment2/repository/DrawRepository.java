package com.example.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment2.entity.Draw;

public interface DrawRepository  extends JpaRepository<Draw, Long>{

}
