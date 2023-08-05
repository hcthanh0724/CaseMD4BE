package com.casemodule.repository;

import com.casemodule.model.Status;
import com.casemodule.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStatusRepo extends JpaRepository<Status, Integer> {

}
