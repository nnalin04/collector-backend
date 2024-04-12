package com.collector.collectorbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "file")
@NoArgsConstructor
@AllArgsConstructor
public class FileData {
    @Id
    private String id;
    private String fileName;
    private byte[] data;
}
