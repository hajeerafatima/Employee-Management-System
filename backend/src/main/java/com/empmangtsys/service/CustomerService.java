package com.empmangtsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.empmangtsys.dto.CustomerRegisterDto;
import com.empmangtsys.model.Customer;
import com.empmangtsys.repo.CustomerRepository;


@Service
public class CustomerService implements UserDetailsService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	 @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	 @Bean
//	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//	       return new BCryptPasswordEncoder();
//	    }
//		
//	 @Autowired
//	 BCryptPasswordEncoder bCryptPasswordEncoder;

	public String registerCustomer(CustomerRegisterDto customerRegisterDto) {
		
		Customer customer = new Customer();
		customer.setFirstname(customerRegisterDto.getFirstname());
		customer.setLastname(customerRegisterDto.getLastname());
		customer.setEmail(customerRegisterDto.getEmail());
		customer.setPassword(bCryptPasswordEncoder.encode(customerRegisterDto.getPassword()));
		customer.setConfirmpassword(customerRegisterDto.getConfirmpassword());

		customerRepository.save(customer);

		return "User Created Successfully. Please Login Now.";
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = this.customerRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found with email :"+username));
		return user;
	}
}

