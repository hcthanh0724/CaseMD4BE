package com.casemodule.repository;


import com.casemodule.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificationRepo extends JpaRepository<Notification, Integer> {
    List<Notification> getNotificationByAccountId(int account_id);
}