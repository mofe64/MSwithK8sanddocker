package com.nubari.clients.notification.requests;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
