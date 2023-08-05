package com.casemodule.controller.admin;

import com.casemodule.model.Friendship;
import com.casemodule.service.impl.FriendshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//dung
@RestController
@CrossOrigin("*")
@RequestMapping("/friendship/{idAccount}")
public class AFriendShipControllerAPI {
    @Autowired
    private FriendshipServiceImpl friendshipService;
    @GetMapping
    private ResponseEntity<List<Friendship>> getAllFriendRequestByUserId(@PathVariable int idAccount){
        return new ResponseEntity<>(friendshipService.getAllFriendShipByUserId(idAccount), HttpStatus.ACCEPTED);
    }
    @PostMapping("/{id_user}")
    private ResponseEntity<?> addFriend(@PathVariable int id_user, @PathVariable int idAccount){
        friendshipService.addFriend(idAccount,id_user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> unFriend(@PathVariable int id){
        friendshipService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
