package com.webinorbit.security.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserIdAndReadFalse(Long userId); // Unread notifications

    List<Notification> findByUserId(Long userId); // All notifications for a user

    List<Notification> findByUserIdAndRead(Long userId, boolean read); // Filter by read status

    @Override
    <S extends Notification> S save(S entity);
}
