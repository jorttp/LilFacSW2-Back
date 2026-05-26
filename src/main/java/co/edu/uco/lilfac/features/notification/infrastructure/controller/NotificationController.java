package co.edu.uco.lilfac.features.notification.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.lilfac.features.notification.application.service.NotificationService;
import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.entity.NotificationJPAEntity;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<List<NotificationJPAEntity>> listarTodas() {
        return ResponseEntity.ok(notificationService.listAll());
    }
}
