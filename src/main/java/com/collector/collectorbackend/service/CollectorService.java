package com.collector.collectorbackend.service;

import com.collector.collectorbackend.model.CollectorItem;
import com.collector.collectorbackend.model.FileData;
import com.collector.collectorbackend.dao.CollectorItemDTO;
import com.collector.collectorbackend.dao.ResponseMessage;
import com.collector.collectorbackend.repository.CollectorRepository;
import com.collector.collectorbackend.repository.CollectorItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollectorService {

    private final CollectorRepository collectorRepository;
    private final CollectorItemRepository collectorItemRepository;

    public CollectorItem uploadNewItem(CollectorItemDTO file) throws IOException {
        return collectorItemRepository.save(CollectorItem.builder().name(file.getName())
                .description(file.getDescription())
                .fileData(FileData.builder()
                        .fileName(file.getFile().getName())
                        .data(file.getFile().getBytes())
                        .build())
                .build());
    }

    public CollectorItem updateItemById(CollectorItemDTO collectorItemDTO) {
        Optional<CollectorItem> collectorItemOptional = collectorItemRepository.findById(collectorItemDTO.getId());
        CollectorItem collectorItem = null;
        if (collectorItemOptional.isPresent()) {
            collectorItem = collectorItemOptional.get();
            if (!collectorItemDTO.getName().isBlank()) {
                collectorItem.setName(collectorItemDTO.getName());
            }
            if (!collectorItemDTO.getDescription().isBlank()) {
                collectorItem.setDescription(collectorItemDTO.getDescription());
            }
        }
        assert collectorItem != null;
        return collectorItemRepository.save(collectorItem);
    }

    public List<CollectorItem> listAllItem() {
        return collectorItemRepository.findAll();
    }

    public ResponseMessage deleteItemById(String id) {
        collectorItemRepository.deleteById(id);
        return ResponseMessage.builder().message("Deleted :" + id).id(id).build();
    }
}
