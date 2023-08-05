package com.casemodule.service.impl;

import com.casemodule.model.Account;
import com.casemodule.model.Post;
import com.casemodule.model.Status;
import com.casemodule.repository.IAccountRepo;
import com.casemodule.service.IAccountService;
import com.casemodule.service.ICommentService;
import com.casemodule.service.IPostService;
import com.casemodule.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepo iAccountRepo;
    @Autowired
    LikeServiceImpl likeService;
    @Autowired
    FriendshipServiceImpl friendshipService;
    @Autowired
    FriendRequestServiceImpl friendRequestService;
    @Autowired
    IPostService postService;
    @Autowired
    ICommentService commentService;
    @Autowired
    IStatusService iStatusService;
    @Override
    public Account getAccountLogin(String username, String password) {
        return iAccountRepo.getAccountLogin(username, password);
    }

    @Override
    public List<Account> getAll() {
        return iAccountRepo.findAll();
    }

    @Override
    public Account findById(int id) {
        Optional<Account> accountOptional = iAccountRepo.findById(id);
        return accountOptional.orElse(null);
    }
//thành
    @Override
    public Account add(Account account) {
        return iAccountRepo.save(account);
    }

    @Override
    public Account edit(Account account) {
        return iAccountRepo.save(account);
    }

    @Override
    public void delete(int id) {
        Status status = iStatusService.findById(8);
        Account account = findById(id);
        account.setStatusAccount(status);
        iAccountRepo.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.getAccountByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUsername(),account.getPassword(),roles);
    }
}
