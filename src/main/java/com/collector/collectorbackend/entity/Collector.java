package com.collector.collectorbackend.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "collector")
public class Collector {

    @Id
    String id;
    String email;
    String password;
    List<FileData> file;
}
