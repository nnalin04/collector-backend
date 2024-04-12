package com.collector.collectorbackend.controller;

import com.collector.collectorbackend.entity.Collector;
import com.collector.collectorbackend.entity.FileData;
import com.collector.collectorbackend.service.CollectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CollectorController {

    private final CollectorService service;

    @GetMapping("/login")
    Collector login(@RequestBody Collector collector) {
        return service.login(collector);
    }

    @PostMapping("/upload")
    List<FileData> upload(@RequestBody Collector collector, @RequestParam("file") MultipartFile file) throws IOException {
        return service.upload(collector, file);
    }
}
