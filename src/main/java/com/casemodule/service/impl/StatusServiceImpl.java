package com.casemodule.service.impl;

import com.casemodule.model.Status;
import com.casemodule.model.Video;
import com.casemodule.repository.IPostRepo;
import com.casemodule.repository.IStatusRepo;
import com.casemodule.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements IStatusService {
    @Autowired
    private IStatusRepo iStatusRepo;
    @Autowired
    private IPostRepo iPostRepo;

    @Override
    public List<Status> findAll() {
        return iStatusRepo.findAll();
    }

    @Override
    public Status findById(int id) {
        Optional<Status> statusOptional = iStatusRepo.findById(id);
        return statusOptional.orElse(null);
    }

    @Override
    public void delete(int id) {
        iStatusRepo.deleteById(id);
    }

    @Override
    public void save(Status status) {
        iStatusRepo.save(status);
    }
}
