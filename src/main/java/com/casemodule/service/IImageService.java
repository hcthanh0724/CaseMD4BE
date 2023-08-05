package com.casemodule.service;

import com.casemodule.model.FriendRequest;
import com.casemodule.model.Friendship;
import com.casemodule.model.Image;

import java.util.List;

public interface IImageService {
    List<Image> findAll();
    void save(Image image);
    void delete(int id);
    Image findById(int id);
}