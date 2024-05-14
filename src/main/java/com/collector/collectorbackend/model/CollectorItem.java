package com.collector.collectorbackend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document
public class CollectorItem {
    @Id
    private String id;
    private FileData fileData;
    private String name;
    private String description;

}
