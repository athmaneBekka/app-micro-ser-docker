package os.bek.accountservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import os.bek.accountservice.clients.CustomerRestClient;
import os.bek.accountservice.entities.BankAccount;
import os.bek.accountservice.model.Customer;
import os.bek.accountservice.repository.BankAccountRepository;

import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList() {
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        bankAccountList.forEach(acc-> {
                acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return bankAccountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElse(null);
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
