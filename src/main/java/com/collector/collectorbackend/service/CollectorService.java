package com.collector.collectorbackend.service;

import com.collector.collectorbackend.model.FileData;
import com.collector.collectorbackend.model.NewFileData;
import com.collector.collectorbackend.repository.CollectorRepository;
import com.collector.collectorbackend.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectorService {

    private final CollectorRepository collectorRepository;
    private final FileRepository fileRepository;

    public List<FileData> upload(NewFileData file) throws IOException {
        FileData fileDocument = new FileData();
        fileDocument.setFileName(file.getFile().getOriginalFilename());
        fileDocument.setData(file.getFile().getBytes());
        fileRepository.save(fileDocument);
        return listFiles();
    }

    public List<FileData> listFiles() {
        return fileRepository.findAll();
    }
}
