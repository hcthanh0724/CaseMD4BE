package com.casemodule.service.impl;

import com.casemodule.model.Comment;
import com.casemodule.model.Post;
import com.casemodule.repository.ICommentRepo;
import com.casemodule.repository.IPostRepo;
import com.casemodule.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostRepo iPostRepo;
    @Autowired
    private ICommentRepo iCommentRepo;
//thành
    @Override
    public List<Post> getAll() {
        return iPostRepo.findAll();
    }

    @Override
    public List<Post> getAllPostByAccountId(int account_id) {
        return iPostRepo.getAllPostByAccountId(account_id);
    }

    @Override
    public void save(Post post) {
        iPostRepo.save(post);
    }

    @Override
    public void edit(Post post) {
        iPostRepo.save(post);
    }

    @Override
    public void delete(int id) {

    }

    //    @Override
//    public void delete(int id) {
//        iCommentRepo.deleteAllCommentByPostId(id);
//    }
    @Override
    public Post findById(int id) {
        Optional<Post> postOptional = iPostRepo.findById(id);
        return postOptional.orElse(null);
    }
}
