package co.edu.uco.lilfac.features.worker.addworker.application.service.impl;

import org.springframework.stereotype.Service;

import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;

import co.edu.uco.lilfac.application.util.UtilSecurity;
import co.edu.uco.lilfac.features.notification.application.service.NotificationService;
import co.edu.uco.lilfac.features.worker.addworker.application.service.PhoneVerificationService;
import co.edu.uco.lilfac.infrastructure.config.TwilioConfig;

@Service
public class TwilioVerificationService implements PhoneVerificationService {

    private final TwilioConfig twilioConfig;
    private final NotificationService notificationService;

    public TwilioVerificationService(TwilioConfig twilioConfig, NotificationService notificationService) {
        this.twilioConfig = twilioConfig;
        this.notificationService = notificationService;
    }

    @Override
    public void sendSmsCode(String phoneNumber) {
        try {
            Verification.creator(
                    twilioConfig.getVerifyServiceSid(),
                    phoneNumber,
                    "sms"
            ).create();
            notificationService.register("SMS", phoneNumber, "Código de verificación enviado", "ENVIADO", UtilSecurity.getCurrentUser());
        } catch (Exception e) {
            notificationService.register("SMS", phoneNumber, "Error al enviar código", "FALLIDO", UtilSecurity.getCurrentUser());
            throw e;
        }
    }

    @Override
    public boolean verifySmsCode(String phoneNumber, String code) {
        VerificationCheck check = VerificationCheck.creator(
                twilioConfig.getVerifyServiceSid()
        ).setTo(phoneNumber).setCode(code).create();

        boolean approved = "approved".equals(check.getStatus().toString());
        notificationService.register("SMS", phoneNumber, "Verificación de código", approved ? "APROBADO" : "RECHAZADO", UtilSecurity.getCurrentUser());
        return approved;
    }
}
