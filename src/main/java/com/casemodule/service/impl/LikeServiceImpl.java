package com.casemodule.service.impl;

import com.casemodule.model.Comment;
import com.casemodule.model.Like;
import com.casemodule.repository.ICommentRepo;
import com.casemodule.repository.ILikeRepo;
import com.casemodule.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements ILikeService {



    // ThanLike
    @Autowired
    private ILikeRepo iLikeRepo;
    @Override
    public List<Like> getAllLikeByPostId(int id) {
        return iLikeRepo.getAllByPostId(id);
    }
    @Override
    public Like findById(int id) {
        Optional<Like> likeOptional = iLikeRepo.findById(id);
        return likeOptional.orElse(null);
    }

    @Override
    public void delete(int id) {
        iLikeRepo.deleteById(id);
    }

    @Override
    public void save(Like like) {
        iLikeRepo.save(like);
    }
}
