package com.casemodule.service;

public interface IMessageService {
    void deleteAllByReceiverId(int id_receiver);
    void deleteAllBySenderId(int id_receiver);
}
