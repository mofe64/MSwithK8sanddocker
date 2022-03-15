package com.nubari.customer.dtos.requests;

public record CustomerRegistrationRequest(
        String firstname,
        String lastName,
        String email
) {
}
