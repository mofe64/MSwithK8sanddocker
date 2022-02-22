package com.nubari.clients.notification;

import com.nubari.clients.notification.requests.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification")
public interface NotificationClient {
    @PostMapping("api/v1/notification")
    void sendNotification(NotificationRequest request);
}
