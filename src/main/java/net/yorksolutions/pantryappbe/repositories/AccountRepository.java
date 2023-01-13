package net.yorksolutions.pantryappbe.repositories;

import net.yorksolutions.pantryappbe.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
    Optional<Account> getAccountByEmailAndPassword(String email, String password);
}
