package io.munkush.com.configuration;

import io.munkush.com.entity.Authority;
import io.munkush.com.entity.Customer;
import io.munkush.com.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private final CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = customerRepository.findByEmail(username).get(0);

        List<SimpleGrantedAuthority> authorities = customer.getAuthorities()
                .stream().map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .toList();

        return CustomUserDetails
                .builder()
                .email(customer.getEmail())
                .authorities(authorities)
                .password(customer.getPwd())
                .build();
    }

}
