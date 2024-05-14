package com.collector.collectorbackend.controller;

import com.collector.collectorbackend.model.FileData;
import com.collector.collectorbackend.model.NewFileData;
import com.collector.collectorbackend.service.CollectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("collector")
@RequiredArgsConstructor
public class CollectorController {

    private final CollectorService service;

    @GetMapping("")
    public String getUser() {
        return "Welcome User";
    }

    @PostMapping("/upload")
    public List<FileData> uploadFile(@ModelAttribute NewFileData file) throws IOException{
        return service.upload(file);
    }

    @GetMapping("/list")
    public List<FileData> listFiles() {
        return service.listFiles();
    }

}
