package com.casemodule.service;
import com.casemodule.model.FriendRequest;
import com.casemodule.model.Friendship;

import java.util.List;

public interface IFriendshipService{
    //dung
    List<Friendship> getAllFriendShipByUserId(int id);
    void addFriend(int idAccount,int id_user);
    void delete(int id);
    FriendRequest findById(int id);
}

