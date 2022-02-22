package com.nubari.customer.services;

import com.nubari.customer.dtos.requests.CustomerRegistrationRequest;
import com.nubari.customer.dtos.responses.FraudCheckResponse;
import com.nubari.customer.model.Customer;
import com.nubari.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerServiceImpl(
        CustomerRepository repository,
        RestTemplate restTemplate
) implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastName())
                .email(request.email())
                .build();
        repository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }


    }
}
