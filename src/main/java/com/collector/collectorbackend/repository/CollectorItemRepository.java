package com.collector.collectorbackend.repository;

import com.collector.collectorbackend.model.CollectorItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollectorItemRepository extends MongoRepository<CollectorItem, String> {
}
