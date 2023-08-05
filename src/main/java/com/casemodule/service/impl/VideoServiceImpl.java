package com.casemodule.service.impl;

import com.casemodule.model.Video;
import com.casemodule.repository.IVideoRepo;
import com.casemodule.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements IVideoService {
    @Autowired
    private IVideoRepo iVideoRepo;

    @Override
    public List<Video> findAll() {
        return iVideoRepo.findAll();
    }

    @Override
    public Video findById(int id) {
        Optional<Video> videoOptional = iVideoRepo.findById(id);
        return videoOptional.orElse(null);
    }

    @Override
    public void delete(int id) {
        iVideoRepo.deleteById(id);
    }

    @Override
    public void save(Video video) {
        iVideoRepo.save(video);
    }
}
