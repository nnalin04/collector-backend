package com.collector.collectorbackend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Collector {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private CollectorItem collectorItem;
}
