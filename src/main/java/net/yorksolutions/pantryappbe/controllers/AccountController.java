package net.yorksolutions.pantryappbe.controllers;

import net.yorksolutions.pantryappbe.DTO.AccountDTO;
import net.yorksolutions.pantryappbe.models.Account;
import net.yorksolutions.pantryappbe.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
    AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //C
    @PostMapping()
    public void createAccount(@RequestBody AccountDTO account) {
        try {
            accountService.createAccount(account);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }

    //R

    @GetMapping
    public Iterable<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }


    @GetMapping(params = {"email", "password"})
    public Account getAccountByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        try {
            return accountService.getAccountByEmailAndPassword(email, password);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    //U
    //D
}
