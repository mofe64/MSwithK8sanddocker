package com.nubari.customer.controller;

import com.nubari.customer.dtos.requests.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController() {
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request) {}
}
