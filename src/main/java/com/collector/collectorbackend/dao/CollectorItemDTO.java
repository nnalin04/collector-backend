package com.collector.collectorbackend.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class CollectorItemDTO {
    @Id
    private String id;
    private byte[] file;
    private String name;
    private String description;
}
