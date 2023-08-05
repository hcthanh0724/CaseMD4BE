package com.casemodule.controller.admin;

import com.casemodule.model.FriendRequest;
import com.casemodule.service.impl.FriendRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//dung
@RestController
@CrossOrigin("*")
@RequestMapping("/friendrequest")
public class AFriendRequestController {
    @Autowired
    private FriendRequestServiceImpl friendRequestService;
    @GetMapping("/{id_user_login}")
    private ResponseEntity<List<FriendRequest>> getAll(@PathVariable int id_user_login){
        return new ResponseEntity<>(friendRequestService.getAllFriendRequestByReceiver(id_user_login), HttpStatus.OK);
    }
    @PostMapping("/{id}")
    private ResponseEntity<?> accept(@PathVariable int id){
        friendRequestService.accept(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> cancel(@PathVariable int id){
        friendRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
