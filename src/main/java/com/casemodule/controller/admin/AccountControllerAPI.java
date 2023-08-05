package com.casemodule.controller.admin;

import com.casemodule.model.Account;
import com.casemodule.service.IAccountService;
import com.casemodule.service.ICommentService;
import com.casemodule.service.IPostService;
import com.casemodule.service.impl.FriendRequestServiceImpl;
import com.casemodule.service.impl.FriendshipServiceImpl;
import com.casemodule.service.impl.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AccountControllerAPI {
    @Autowired
    IAccountService accountService;

    //    @PostMapping("/login")
//    public AccountDTO getLogin(@RequestBody Account account){
//        Account account1 = accountService.getAccountLogin(account.getUsername(), account.getPassword());
//        if (account1 != null){
//            httpSession.setAttribute("account", account1);
//        }
//        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);
//        AccountDTO accountDTO = mapper.accountToAccountDTO(account1);
//        return accountDTO;
//    }
    @PostMapping("/register")
    public Account register(@RequestBody Account account){
        return account;
    }

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}