package com.collector.collectorbackend.service;

import com.collector.collectorbackend.entity.Collector;
import com.collector.collectorbackend.entity.FileData;
import com.collector.collectorbackend.repository.CollectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CollectorService {

    private final CollectorRepository repository;

    public Collector login(Collector collector) {
        Collector collectorByEmail = repository.findByEmail(collector.getEmail());
        if (Objects.isNull(collectorByEmail)) {
            return repository.save(collector);
        } else {
            if (collectorByEmail.getPassword().equals(collector.getPassword())) {
                return collectorByEmail;
            }
            return null;
        }
    }

    public List<FileData> upload(Collector collector, MultipartFile file) throws IOException {
        Collector collectorByEmail = repository.findByEmail(collector.getEmail());
        List<FileData> files = collectorByEmail.getFile();
        files.add(getFileData(file));
        collectorByEmail.getFile().clear();
        collector.getFile().addAll(files);
        return repository.save(collectorByEmail).getFile();
    }

    public FileData getFileData(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        byte[] data = file.getBytes();
        FileData fileData = new FileData();
        fileData.setFileName(fileName);
        fileData.setData(data);
        return fileData;
    }


}
