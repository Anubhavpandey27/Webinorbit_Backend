package com.webinorbit.security.notification;

import com.webinorbit.security.user.User;
import com.webinorbit.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final UserRepository userRepository;

    @PostMapping("/sendToUser/{userId}")
    public ResponseEntity<String> sendNotificationToUser(
            @PathVariable Integer userId, @RequestBody String message) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        notificationService.sendNotificationToUser(message, user);
        String jsonResponse = "{\"status\":\"Notification sent to user with ID: " + userId + "\"}";
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json").body(jsonResponse);
    }

    @PostMapping("/sendToAll")
    public ResponseEntity<String> sendNotificationToAllUsers(@RequestBody String message) {
        notificationService.sendNotificationToAllUsers(message);
        String jsonResponse = "{\"status\":\"Notification sent to all users\"}";
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json").body(jsonResponse);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getAllNotifications(@PathVariable Long userId) {
        List<Notification> notifications = notificationService.getAllNotifications(userId);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/user/{userId}/unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications(@PathVariable Long userId) {
        List<Notification> unreadNotifications = notificationService.getUnreadNotifications(userId);
        return ResponseEntity.ok(unreadNotifications);
    }

    @GetMapping("/user/{userId}/read")
    public ResponseEntity<List<Notification>> getReadNotifications(@PathVariable Long userId) {
        List<Notification> readNotifications = notificationService.getNotificationsByReadStatus(userId, true);
        return ResponseEntity.ok(readNotifications);
    }

    @PostMapping("/markAsRead/{notificationId}")
    public ResponseEntity<String> markNotificationAsRead(@PathVariable Long notificationId) {
        notificationService.markAsRead(notificationId);
        String jsonResponse = "{\"status\":\"Notification marked as read\"}";
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json").body(jsonResponse);
    }
}
