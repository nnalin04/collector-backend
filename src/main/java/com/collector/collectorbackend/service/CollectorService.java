package com.collector.collectorbackend.service;

import com.collector.collectorbackend.model.FileData;
import com.collector.collectorbackend.model.NewFileData;
import com.collector.collectorbackend.model.ResponseMessage;
import com.collector.collectorbackend.repository.CollectorRepository;
import com.collector.collectorbackend.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectorService {

    private final CollectorRepository collectorRepository;
    private final FileRepository fileRepository;

    public List<FileData> upload(MultipartFile file) throws IOException {
        FileData fileDocument = new FileData();
        fileDocument.setFileName(file.getOriginalFilename());
        fileDocument.setData(file.getBytes());
        fileRepository.save(fileDocument);
        return listFiles();
    }

    public List<FileData> listFiles() {
        return fileRepository.findAll();
    }

    public ResponseMessage delete(String id) {
        fileRepository.deleteById(id);
        return ResponseMessage.builder().message("Deleted :" + id).id(id).build();
    }
}
