package com.collector.collectorbackend.controller;

import com.collector.collectorbackend.service.CollectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("collecter")
@RequiredArgsConstructor
public class CollectorController {

    private final CollectorService service;

    @GetMapping
    public String welcome(@RequestParam("name") String name) {
        return "Welcome new customer "+ name;
    }

}
