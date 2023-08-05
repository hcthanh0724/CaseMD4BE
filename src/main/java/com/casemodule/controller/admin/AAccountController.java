package com.casemodule.controller.admin;

import com.casemodule.model.Account;
import com.casemodule.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AAccountController {
    //thành
    @Autowired
    IAccountService accountService;
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccount(){
        List<Account> accounts = accountService.getAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.add(account),HttpStatus.OK);
    }
    @PostMapping("/accounts/{idAccount}")
    public ResponseEntity<Account> updateAccount(@PathVariable int idAccount,@RequestBody Account account){
        account.setId(idAccount);
        return new ResponseEntity<>(accountService.edit(account),HttpStatus.OK);
    }
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable int id) {
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
