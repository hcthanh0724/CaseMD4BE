package com.casemodule.service;

import com.casemodule.model.Video;

import java.util.List;

public interface IVideoService {
    List<Video> findAll();
    Video findById(int id);
    void delete(int id);
    void save(Video video);
}
