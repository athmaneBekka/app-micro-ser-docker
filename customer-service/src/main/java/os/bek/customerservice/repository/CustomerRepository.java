package os.bek.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import os.bek.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
