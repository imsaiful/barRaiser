package com.example.bar.bar.service.impl;

import com.example.bar.bar.dto.NotificationDto;
import com.example.bar.bar.service.NotificationService;

public class MobileNotificationService implements NotificationService {
    @Override
    public boolean send(NotificationDto notificationDto) {
        return false;
    }
}
