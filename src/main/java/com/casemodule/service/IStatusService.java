package com.casemodule.service;

import com.casemodule.model.Status;
import com.casemodule.model.Video;

import java.util.List;

public interface IStatusService {
    List<Status> findAll();
    Status findById(int id);
    void delete(int id);
    void save(Status status);
}
