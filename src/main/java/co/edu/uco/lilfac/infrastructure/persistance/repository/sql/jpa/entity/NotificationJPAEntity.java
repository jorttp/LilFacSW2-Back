package co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notificacion")
public class NotificationJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "destinatario")
    private String destinatario;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    @Column(name = "usuario_id")
    private String usuarioId;

    protected NotificationJPAEntity() {
        super();
    }

    public NotificationJPAEntity(UUID id, String tipo, String destinatario, String mensaje, String estado, LocalDateTime fechaEnvio, String usuarioId) {
        super();
        this.id = id;
        this.tipo = tipo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.usuarioId = usuarioId;
    }

    public UUID getId() { return id; }
    public String getTipo() { return tipo; }
    public String getDestinatario() { return destinatario; }
    public String getMensaje() { return mensaje; }
    public String getEstado() { return estado; }
    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public String getUsuarioId() { return usuarioId; }
}