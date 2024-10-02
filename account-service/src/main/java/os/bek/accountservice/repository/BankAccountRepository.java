package os.bek.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import os.bek.accountservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
