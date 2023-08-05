package com.casemodule.service.impl;

import com.casemodule.model.Notification;
import com.casemodule.model.Post;
import com.casemodule.repository.INotificationRepo;
import com.casemodule.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// duong viet cai nay ne
@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    INotificationRepo notificationRepo;
    @Override
    public List<Notification> getAllNotificationByAccountId(int account_id) {
        return  notificationRepo.getNotificationByAccountId(account_id);
    }

    @Override
    public void save(Notification notification) {
        notificationRepo.save(notification);
    }

    @Override
    public void edit(Notification notification) {
        notificationRepo.save(notification);
    }

    @Override
    public void delete(int id) {
        notificationRepo.deleteById(id);
    }

    @Override
    public Notification findById(int id) {
        Optional<Notification> notificationOptional = notificationRepo.findById(id);
        return notificationOptional.orElse(null);
    }
}