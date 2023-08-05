package com.casemodule.service;

import com.casemodule.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    Account getAccountLogin(String username, String password);
    List<Account> getAll();
    Account findById(int id);
    //thành
    Account add(Account account);
    Account edit(Account account);
    void delete(int id);
}
