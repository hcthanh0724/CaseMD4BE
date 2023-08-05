package com.casemodule.repository;

import com.casemodule.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILikeRepo extends JpaRepository<Like, Integer> {

    // ThanLike
    List<Like> getAllByPostId(int post_id);

}
