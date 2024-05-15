package com.collector.collectorbackend.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class CollectorItemDAO {
    @Id
    private String id;
    private MultipartFile file;
    private String name;
    private String description;
}
