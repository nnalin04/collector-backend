package com.collector.collectorbackend.service;

import com.collector.collectorbackend.model.FileData;
import com.collector.collectorbackend.repository.CollectorRepository;
import com.collector.collectorbackend.repository.FileRepository;
import com.collector.collectorbackend.util.FileDocumentMultipartFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollectorService {

    private final CollectorRepository collectorRepository;
    private final FileRepository fileRepository;

    public List<MultipartFile> upload(MultipartFile file) throws IOException {
        FileData fileDocument = new FileData();
        fileDocument.setFileName(file.getOriginalFilename());
        fileDocument.setData(file.getBytes());
        fileRepository.save(fileDocument);
        return listFiles();
    }

    public List<MultipartFile> listFiles() {
        return fileRepository.findAll().stream()
                .map(fileDocument -> new FileDocumentMultipartFile(fileDocument.getFileName(), fileDocument.getFileName(), fileDocument.getData()))
                .collect(Collectors.toList());
    }
}
