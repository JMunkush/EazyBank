package io.munkush.com.unit.service;

import io.munkush.com.entity.Customer;
import io.munkush.com.repository.CustomerRepository;
import io.munkush.com.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class CustomerServiceTest {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    void shouldSaveCustomer(){
        Customer testCustomer = Customer.builder()
                .email("test@gmail.com")
                .role("TEST")
                .password("asd")
                .build();

        Customer savedTestCustomer = customerService.save(testCustomer);

        assertEquals(savedTestCustomer, testCustomer);

        Customer testCustomerFromDb = customerRepository.findByEmail(testCustomer.getEmail());

        assertEquals(testCustomerFromDb, testCustomer);
    }

}