package os.bek.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import os.bek.accountservice.entities.BankAccount;
import os.bek.accountservice.enums.AccountType;
import os.bek.accountservice.repository.BankAccountRepository;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository) {
        return args -> {
            BankAccount bankAccount1 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("DZ")
                    .balance(99999)
                    .customerId(Long.valueOf(1))
                    .createAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT).build();

            BankAccount bankAccount2 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("DZ")
                    .balance(99999)
                    .createAt(LocalDate.now())
                    .customerId(Long.valueOf(2))
                    .type(AccountType.CURRENT_ACCOUNT).build();

            accountRepository.save(bankAccount1);
            accountRepository.save(bankAccount2);

        };
    }
}
