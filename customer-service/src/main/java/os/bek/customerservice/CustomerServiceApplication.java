package os.bek.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import os.bek.customerservice.config.GlobalConfig;
import os.bek.customerservice.entities.Customer;
import os.bek.customerservice.repository.CustomerRepository;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

	private final CustomerRepository customerRepository;

	public CustomerServiceApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customers = List.of(
					Customer.builder().
							firstName("osmane")
							.lastName("bekka")
							.email("os@gmail.com").build(),
			Customer.builder().
					firstName("osmane2")
					.lastName("bekka2")
					.email("os@gmail.com").build()
			);

			customerRepository.saveAll(customers);
		};
	}

}
