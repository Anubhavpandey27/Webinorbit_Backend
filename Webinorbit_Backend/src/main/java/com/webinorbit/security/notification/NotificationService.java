package com.webinorbit.security.notification;

import com.webinorbit.security.user.User;
import com.webinorbit.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    // AtomicLong for generating unique IDs manually
    private final AtomicLong counter = new AtomicLong(1);

    public void sendNotificationToUser(String message, User user) {
        Notification notification = new Notification();
        notification.setId(counter.getAndIncrement()); // Manually assign a unique ID
        notification.setMessage(message);
        notification.setUser(user);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRead(false);
        notificationRepository.save(notification);
    }

    public void sendNotificationToAllUsers(String message) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            sendNotificationToUser(message, user);
        }
    }

    public List<Notification> getUnreadNotifications(Long userId) {
        return notificationRepository.findByUserIdAndReadFalse(userId);
    }

    public List<Notification> getAllNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public List<Notification> getNotificationsByReadStatus(Long userId, boolean read) {
        return notificationRepository.findByUserIdAndRead(userId, read);
    }

    public void markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found with id: " + notificationId));
        notification.setRead(true);
        notificationRepository.save(notification);
    }
}
