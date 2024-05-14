package com.collector.collectorbackend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
public class FileData {
    private String fileName;
    private byte[] data;
}
