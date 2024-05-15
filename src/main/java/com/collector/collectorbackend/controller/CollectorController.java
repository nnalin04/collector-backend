package com.collector.collectorbackend.controller;

import com.collector.collectorbackend.dao.CollectorItemDTO;
import com.collector.collectorbackend.dao.ResponseMessage;
import com.collector.collectorbackend.model.CollectorItem;
import com.collector.collectorbackend.service.CollectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public ResponseEntity<CollectorItem> uploadFile(@ModelAttribute CollectorItemDTO item) throws IOException {
        return ResponseEntity.ok(service.uploadNewItem(item));
    }

    @PostMapping("/upload_list")
    public ResponseEntity<List<CollectorItem>> uploadFiles(@ModelAttribute List<CollectorItemDTO> items) throws IOException {
        return ResponseEntity.ok(service.uploadNewItems(items));
    }

    @PutMapping("/update_file")
    public ResponseEntity<CollectorItem> updateFile(@ModelAttribute CollectorItemDTO item) {
        return ResponseEntity.ok(service.updateItem(item));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseMessage> delete(@RequestParam("id") String id) {
        return ResponseEntity.ok(service.deleteItemById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CollectorItem>> listFiles() {
        return ResponseEntity.ok(service.listAllItem());
    }
}
