package io.munkush.com.service;

import io.munkush.com.entity.Customer;
import io.munkush.com.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;




    public Customer save(Customer customer){

        if(customer == null){
            throw new IllegalStateException();
        } else {
            return customerRepository.save(customer);
        }

    }

}
