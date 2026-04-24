package com.example.assignment2.controller;


import com.example.assignment2.service.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/draw")
@CrossOrigin
public class DrawController {

    @Autowired
    private DrawService drawService;

    @GetMapping("/run")
    public Map<String, Object> runDraw() {
        return drawService.runDraw();
    }
}