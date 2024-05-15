package com.collector.collectorbackend.service;

import com.collector.collectorbackend.model.CollectorItem;
import com.collector.collectorbackend.model.FileData;
import com.collector.collectorbackend.dao.CollectorItemDAO;
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

    public CollectorItem uploadNewItem(CollectorItemDAO file) throws IOException {
        return collectorItemRepository.save(CollectorItem.builder().name(file.getName())
                .description(file.getDescription())
                .fileData(FileData.builder()
                        .fileName(file.getFile().getName())
                        .data(file.getFile().getBytes())
                        .build())
                .build());
    }

    public CollectorItem updateItemById(CollectorItemDAO collectorItemDAO) {
        Optional<CollectorItem> collectorItemOptional = collectorItemRepository.findById(collectorItemDAO.getId());
        CollectorItem collectorItem = null;
        if (collectorItemOptional.isPresent()) {
            collectorItem = collectorItemOptional.get();
            if (!collectorItemDAO.getName().isBlank()) {
                collectorItem.setName(collectorItemDAO.getName());
            }
            if (!collectorItemDAO.getDescription().isBlank()) {
                collectorItem.setDescription(collectorItemDAO.getDescription());
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
