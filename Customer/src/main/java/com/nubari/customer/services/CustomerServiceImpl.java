package com.nubari.customer.services;

import com.nubari.customer.dtos.requests.CustomerRegistrationRequest;
import com.nubari.customer.model.Customer;
import com.nubari.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(
        CustomerRepository repository
) implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastName())
                .email(request.email())
                .build();

        repository.save(customer);

    }
}
