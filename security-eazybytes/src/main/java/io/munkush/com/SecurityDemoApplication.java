package io.munkush.com;

import io.munkush.com.entity.Authority;
import io.munkush.com.entity.Customer;
import io.munkush.com.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityDemoApplication {

	private final CustomerRepository customerRepository;
	private final PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			Customer customer = new Customer();

			Authority authority = new Authority();
			authority.setCustomer(customer);
			authority.setName("VIEWBALANCE");
			authority.setName("VIEWLOANS");
			customer.setAuthorities(Collections.singleton(authority));
			customer.setEmail("asd@gmail.com");
			customer.setRole("ROLE_USER");
			customer.setPwd(passwordEncoder.encode("asdasd"));

			customerRepository.save(customer);

		};
	}
}
