package com.casemodule.controller.admin;

import com.casemodule.model.Like;
import com.casemodule.model.Post;
import com.casemodule.service.IAccountService;
import com.casemodule.service.ILikeService;
import com.casemodule.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")

// ThanLike


public class ALikeControllerAPI {
    @Autowired
    private ILikeService iLikeService;
    @Autowired
    private IPostService iPostService;
    @Autowired
    private IAccountService iAccountService;
    @GetMapping("/like/{idPost}")
    public List<Like> getAllLikeByPostId(@PathVariable int idPost){
        return iLikeService.getAllLikeByPostId(idPost);
    }
    @PostMapping("/like/{idPost}")
    public ResponseEntity<?> createLike( @PathVariable int idPost,
                                                 @RequestBody Like like) {
//        Account account = iAccountService.findById(idAccount);
        Post post = iPostService.findById(idPost);
//        like.setAccount(account);
        like.setPost(post);
        iLikeService.save(like);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping ("/like/{idLike}")
    public ResponseEntity<Like> deleteLike(@PathVariable int idLike) {
        iLikeService.delete(idLike);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
