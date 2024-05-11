package com.collector.collectorbackend.controller;

import com.collector.collectorbackend.service.CollectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("collecter")
@RequiredArgsConstructor
public class CollectorController {

    private final CollectorService service;

    @GetMapping
    public String welcome() {
        return "Welcome new customer";
    }

    @PostMapping("/upload")
    public List<MultipartFile> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return service.upload(file);
    }

    @GetMapping("/list")
    public List<MultipartFile> listFiles() {
        return service.listFiles();
    }

}
