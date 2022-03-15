package com.nubari.customer.services;

import com.nubari.customer.dtos.requests.CustomerRegistrationRequest;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest request);
}
