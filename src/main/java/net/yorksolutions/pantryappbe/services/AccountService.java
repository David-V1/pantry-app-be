package net.yorksolutions.pantryappbe.services;

import net.yorksolutions.pantryappbe.DTO.AccountDTO;
import net.yorksolutions.pantryappbe.models.Account;
import net.yorksolutions.pantryappbe.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //Crud
    public void createAccount(AccountDTO account) throws Exception {
        //Check existence
        Optional<Account> accountOptional = accountRepository.findByEmail(account.email);
        if (accountOptional.isPresent()) {
            throw new Exception("Account already exists");
        }

        Account newAccount = new Account();
        newAccount.setEmail(account.email);
        newAccount.setPassword(account.password);
        newAccount.setFamilyName(account.familyName);

        accountRepository.save(newAccount);
    }

    //cRud
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountByEmailAndPassword(String email, String password){
        return accountRepository.getAccountByEmailAndPassword(email, password).orElse(null);

    }
    //crUd
    //cruD
}
