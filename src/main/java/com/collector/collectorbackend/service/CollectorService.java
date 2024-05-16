package com.collector.collectorbackend.service;

import com.collector.collectorbackend.dao.CollectorItemDTO;
import com.collector.collectorbackend.dao.ResponseMessage;
import com.collector.collectorbackend.model.CollectorItem;
import com.collector.collectorbackend.model.FileData;
import com.collector.collectorbackend.repository.CollectorItemRepository;
import com.collector.collectorbackend.repository.CollectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollectorService {

    private final CollectorRepository collectorRepository;
    private final CollectorItemRepository collectorItemRepository;

    public CollectorItem uploadNewItem(CollectorItemDTO file) throws IOException {
        return collectorItemRepository.save(getCollector(file));
    }

    public CollectorItem updateItem(CollectorItemDTO collectorItemDTO) {
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
            return collectorItemRepository.save(collectorItem);
        }
        return null;
    }

    public List<CollectorItem> listAllItem() {
        return collectorItemRepository.findAll();
    }

    public ResponseMessage deleteItemById(String id) {
        collectorItemRepository.deleteById(id);
        return ResponseMessage.builder().message("Deleted :" + id).id(id).build();
    }

    public List<CollectorItem> uploadNewItems(List<CollectorItemDTO> items) {
        List<CollectorItem> collectorItems = new ArrayList<>();
        for (CollectorItemDTO itemDTO : items) {
            collectorItems.add(getCollector(itemDTO));
        }
        return collectorItemRepository.saveAll(collectorItems);
    }

    public CollectorItem getCollector(CollectorItemDTO file) {
        return CollectorItem.builder().name(file.getName())
                .description(file.getDescription())
                .fileData(FileData.builder()
                        .fileName(file.getName())
                        .data(file.getFile())
                        .build())
                .build();
    }
}
