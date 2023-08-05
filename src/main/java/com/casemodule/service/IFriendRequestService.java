package com.casemodule.service;

import com.casemodule.model.FriendRequest;
import com.casemodule.model.Post;

import java.util.List;

public interface IFriendRequestService {
    //dung
    List<FriendRequest> getAllFriendRequestByReceiver(int id);
    void accept(int id);
    void delete(int id);
    FriendRequest findById(int id);
}
