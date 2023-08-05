package com.casemodule.repository;

import com.casemodule.model.FriendRequest;
import com.casemodule.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFriendshipRepo extends JpaRepository<Friendship, Integer> {
    //dung
    List<Friendship> getAllByUserId(int user_id);
}
