package com.collector.collectorbackend.service;

import com.collector.collectorbackend.model.CollectorItem;
import com.collector.collectorbackend.model.FileData;
import com.collector.collectorbackend.model.NewFileData;
import com.collector.collectorbackend.model.ResponseMessage;
import com.collector.collectorbackend.repository.CollectorRepository;
import com.collector.collectorbackend.repository.CollectorItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectorService {

    private final CollectorRepository collectorRepository;
    private final CollectorItemRepository collectorItemRepository;

    public CollectorItem upload(NewFileData file) throws IOException {
        return collectorItemRepository.save(CollectorItem.builder().name(file.getName())
                .description(file.getDescription())
                .fileData(FileData.builder()
                        .fileName(file.getFile().getName())
                        .data(file.getFile().getBytes())
                        .build())
                .build());
    }

    public List<CollectorItem> listFiles() {
        return collectorItemRepository.findAll();
    }

    public ResponseMessage delete(String id) {
        collectorItemRepository.deleteById(id);
        return ResponseMessage.builder().message("Deleted :" + id).id(id).build();
    }
}
