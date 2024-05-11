package com.collector.collectorbackend.repository;

import com.collector.collectorbackend.model.Collector;
import com.collector.collectorbackend.model.FileData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileData, String> {
}
