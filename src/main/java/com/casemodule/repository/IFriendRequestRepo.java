package com.casemodule.repository;

import com.casemodule.model.Account;
import com.casemodule.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFriendRequestRepo extends JpaRepository<FriendRequest, Integer> {
    //dung
    List<FriendRequest> getAllByReceiverId(int receiver_id);
}
