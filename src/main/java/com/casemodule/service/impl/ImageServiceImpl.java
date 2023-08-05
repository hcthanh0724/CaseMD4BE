package com.casemodule.service.impl;


import com.casemodule.model.Image;
import com.casemodule.repository.IImageRepo;
import com.casemodule.repository.IImage_postRepo;
import com.casemodule.repository.IPostRepo;
import com.casemodule.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    private IImageRepo iImageRepo;
    @Autowired
    private IPostRepo iPostRepo;
    @Autowired
    private IImage_postRepo iImage_postRepo;
    @Override
    public List<Image> findAll() {
        return iImageRepo.findAll();
    }

    @Override
    public void save(Image image) {
        iImageRepo.save(image);
    }

    @Override
    public void delete(int id) {
       iImage_postRepo.delete(iImage_postRepo.getImage(id));
        iImageRepo.deleteById(id);
    }

    @Override
    public Image findById(int id) {
        return iImageRepo.findById(id).get();
    }
}
