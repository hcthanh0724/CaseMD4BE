package com.casemodule.service;

import com.casemodule.model.Like;

import java.util.List;

public interface ILikeService {


    // ThanLike
    List<Like> getAllLikeByPostId(int id);
    Like findById(int id);
    void delete(int id);
    void save(Like like);
}
