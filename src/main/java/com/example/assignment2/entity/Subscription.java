package com.example.assignment2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity  
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String plan;

    private String status;

    private LocalDate renewalDate;
}