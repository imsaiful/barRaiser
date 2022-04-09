package com.example.bar.bar.service;

import com.example.bar.bar.dto.NotificationDto;

public interface NotificationService {
    public boolean send(NotificationDto notificationDto);
}
