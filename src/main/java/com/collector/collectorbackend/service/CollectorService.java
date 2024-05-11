package com.collector.collectorbackend.service;

import com.collector.collectorbackend.repository.CollectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CollectorService {

    private final CollectorRepository repository;

}
