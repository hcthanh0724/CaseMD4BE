package com.casemodule.controller.admin;
// duong viet
import com.casemodule.model.Account;
import com.casemodule.model.Comment;
import com.casemodule.model.Post;
import com.casemodule.service.IAccountService;
import com.casemodule.service.ICommentService;
import com.casemodule.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class ACommentControllerAPI {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IPostService postService;
    @Autowired
    private ICommentService commentService;

    @GetMapping("/comments/{idPost}")
    public ResponseEntity<List<Comment>> getAllCommentByPostId(@PathVariable int idPost) {
        return new ResponseEntity<>(commentService.getAllCommentByPostId(idPost), HttpStatus.OK);
    }

//    @PostMapping("/comments")
//    public ResponseEntity<Comment> createComment( @RequestBody Comment comment) {
////        Account account = accountService.findById(idAccount);
////        Post post = postService.findById(idPost);
////        comment.setAccount(account);
////        comment.setPost(post);
//        commentService.save(comment);
//        return new ResponseEntity<>(comment, HttpStatus.OK);
//    }

    @DeleteMapping("/comments/{idComment}")
    public ResponseEntity<Comment> deleteComment(@PathVariable int idComment) {
        Comment comment = commentService.findById(idComment);
        commentService.delete(idComment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

//    @PostMapping("/comments/{idComment}")
//    public ResponseEntity<Comment> updateComment( @PathVariable int idComment, @RequestBody Comment comment) {
//        comment.setId(idComment);
//        commentService.edit(comment);
//        return new ResponseEntity<>(comment, HttpStatus.OK);
//    }
}
