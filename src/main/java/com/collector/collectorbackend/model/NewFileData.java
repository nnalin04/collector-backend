package com.collector.collectorbackend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class NewFileData {
    private MultipartFile file;
    private String name;
    private String description;
}
