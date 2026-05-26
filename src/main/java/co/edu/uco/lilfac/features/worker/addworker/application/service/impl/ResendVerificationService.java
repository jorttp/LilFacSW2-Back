package co.edu.uco.lilfac.features.worker.addworker.application.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;

import co.edu.uco.lilfac.application.util.UtilSecurity;
import co.edu.uco.lilfac.features.notification.application.service.NotificationService;
import co.edu.uco.lilfac.features.worker.addworker.application.service.EmailVerificationService;

@Service
public class ResendVerificationService implements EmailVerificationService {

    private final Resend resend;
    private final Map<String, String> codesStore = new HashMap<>();
    private final NotificationService notificationService;

    public ResendVerificationService(Resend resend, NotificationService notificationService) {
        this.resend = resend;
        this.notificationService = notificationService;
    }

    @Override
    public void sendEmailCode(String email) {
        String code = String.format("%06d", new Random().nextInt(999999));
        codesStore.put(email, code);

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("Lilfac <onboarding@resend.dev>")
                .to(email)
                .subject("Código de verificación Lilfac")
                .html("<h2>Tu código de verificación es: <strong>" + code + "</strong></h2>" +
                      "<p>Este código expira en 5 minutos.</p>")
                .build();

        try {
            resend.emails().send(params);
            notificationService.register("EMAIL", email, "Código de verificación enviado", "ENVIADO", UtilSecurity.getCurrentUser());
        } catch (ResendException e) {
        	notificationService.register("EMAIL", email, "Error al enviar código", "FALLIDO", UtilSecurity.getCurrentUser());
            throw new RuntimeException("Error al enviar el correo de verificación: " + e.getMessage());
        }
    }

    @Override
    public boolean verifyEmailCode(String email, String code) {
        String storedCode = codesStore.get(email);
        if (storedCode != null && storedCode.equals(code)) {
            codesStore.remove(email);
            notificationService.register("EMAIL", email, "Verificación de código", "APROBADO", UtilSecurity.getCurrentUser());
            return true;
        }
        notificationService.register("EMAIL", email, "Verificación de código fallida", "RECHAZADO", UtilSecurity.getCurrentUser());
        return false;
    }
}