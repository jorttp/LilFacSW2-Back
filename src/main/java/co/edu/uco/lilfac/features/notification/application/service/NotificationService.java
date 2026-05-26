package co.edu.uco.lilfac.features.notification.application.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.NotificationJPARepository;
import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.entity.NotificationJPAEntity;

@Service
public class NotificationService {

    private final NotificationJPARepository repository;

    public NotificationService(NotificationJPARepository repository) {
        this.repository = repository;
    }

    public void register(String tipo, String destinatario, String mensaje, String estado, String usuarioId) {
        NotificationJPAEntity notification = new NotificationJPAEntity(
                UUID.randomUUID(),
                tipo,
                destinatario,
                mensaje,
                estado,
                LocalDateTime.now(),
                usuarioId
        );
        repository.save(notification);
    }

    public java.util.List<NotificationJPAEntity> listAll() {
        return repository.findAll();
    }
}