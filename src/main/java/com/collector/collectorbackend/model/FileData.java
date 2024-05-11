package com.collector.collectorbackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class FileData {
    @Id
    private String id;
    private String fileName;
    private byte[] data;

}
