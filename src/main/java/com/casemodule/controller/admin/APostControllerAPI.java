package com.casemodule.controller.admin;

import com.casemodule.model.Post;
import com.casemodule.repository.ICommentRepo;
import com.casemodule.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class APostControllerAPI {
    @Autowired
    IPostService iPostService;
    @GetMapping("/post")
    public ResponseEntity<List<Post>> getAllPost(){
        return new ResponseEntity<>(iPostService.getAll(), HttpStatus.OK);
    }
    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable int id){
        iPostService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
