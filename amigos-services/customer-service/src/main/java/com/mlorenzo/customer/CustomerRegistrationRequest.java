package com.mlorenzo.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
