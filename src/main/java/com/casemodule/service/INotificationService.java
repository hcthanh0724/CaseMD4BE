package com.casemodule.service;
import com.casemodule.model.Notification;
//duong viet

import java.util.List;

public interface INotificationService {
    List<Notification> getAllNotificationByAccountId(int id);
    void save(Notification notification);
    void edit(Notification notification);
    void delete(int id);
    Notification findById(int id);
}