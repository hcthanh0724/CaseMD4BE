package com.casemodule.service.impl;

import com.casemodule.model.FriendRequest;
import com.casemodule.model.Friendship;
import com.casemodule.repository.IAccountRepo;
import com.casemodule.repository.IFriendRequestRepo;
import com.casemodule.repository.IFriendshipRepo;
import com.casemodule.service.IFriendshipService;
import jdk.vm.ci.meta.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class FriendshipServiceImpl implements IFriendshipService {
    //dung
    @Autowired
    private IFriendshipRepo iFriendshipRepo;
    @Autowired
    private IFriendRequestRepo iFriendRequestRepo;
    @Autowired
    private IAccountRepo iAccountRepo;

    @Override
    public List<Friendship> getAllFriendShipByUserId(int id) {
        return iFriendshipRepo.getAllByUserId(id);
    }

    @Override
    public void addFriend(int idAccount,int id_user) {
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setCreatedAt(Date.valueOf(LocalDate.now()));
        friendRequest.setSender(iAccountRepo.findById(idAccount).get());
        friendRequest.setReceiver(iAccountRepo.findById(id_user).get());
        iFriendRequestRepo.save(friendRequest);
    }

    @Override
    public void delete(int id) {
        iFriendshipRepo.deleteById(id);
    }

    @Override
    public FriendRequest findById(int id) {
        return null;
    }
}
