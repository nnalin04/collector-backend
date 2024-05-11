package com.collector.collectorbackend.repository;

import com.collector.collectorbackend.model.Collector;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectorRepository extends MongoRepository<Collector, String> {

    Collector findByEmail(String email);
}
