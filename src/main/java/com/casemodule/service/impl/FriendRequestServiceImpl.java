package com.casemodule.service.impl;

import com.casemodule.model.FriendRequest;
import com.casemodule.model.Friendship;
import com.casemodule.model.Post;
import com.casemodule.repository.IFriendRequestRepo;
import com.casemodule.repository.IFriendshipRepo;
import com.casemodule.service.IFriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class FriendRequestServiceImpl implements IFriendRequestService {
    //dung
    @Autowired
    private IFriendRequestRepo iFriendRequestRepo;
    @Autowired
    private IFriendshipRepo iFriendshipRepo;

    @Override
    public List<FriendRequest> getAllFriendRequestByReceiver(int id) {
        return iFriendRequestRepo.getAllByReceiverId(id);
    }

    @Override
    public void accept(int id) {
        FriendRequest friendRequest =  findById(id);
        Friendship friendship = new Friendship();
        friendship.setCreateAt(Date.valueOf(LocalDate.now()));
        friendship.setFriend(friendRequest.getReceiver());
        friendship.setUser(friendRequest.getSender());
        iFriendshipRepo.save(friendship);
    }


    @Override
    public void delete(int id) {
        iFriendRequestRepo.deleteById(id);
    }

    @Override
    public FriendRequest findById(int id) {
        return iFriendRequestRepo.findById(id).get();
    }
}
