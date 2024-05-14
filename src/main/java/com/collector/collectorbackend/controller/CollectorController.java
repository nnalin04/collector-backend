package com.collector.collectorbackend.controller;

import com.collector.collectorbackend.model.CollectorItem;
import com.collector.collectorbackend.model.NewFileData;
import com.collector.collectorbackend.model.ResponseMessage;
import com.collector.collectorbackend.service.CollectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

@CrossOrigin("*")
@RestController
@RequestMapping("/collector")
@RequiredArgsConstructor
public class CollectorController {

    private final CollectorService service;

    @GetMapping("")
    public String getUser() {
        return "Welcome User";
    }

    @PostMapping("/upload")
    public ResponseEntity<CollectorItem> uploadFile(@RequestBody NewFileData newFileData) throws IOException {
        return ResponseEntity.ok(service.upload(newFileData));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseMessage> delete(@RequestParam("id") String id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CollectorItem>> listFiles() {
        return ResponseEntity.ok(service.listFiles());
    }
}
