package co.edu.uco.lilfac.features.worker.addworker.infrastructure.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.lilfac.features.worker.addworker.application.service.EmailVerificationService;

@RestController
@RequestMapping("/api/v1/verification")
public class EmailVerificationController {

    private final EmailVerificationService emailVerificationService;

    public EmailVerificationController(EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("/email/send")
    public ResponseEntity<String> sendEmailCode(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        emailVerificationService.sendEmailCode(email);
        return ResponseEntity.ok("Código enviado a " + email);
    }

    @PostMapping("/email/verify")
    public ResponseEntity<String> verifyEmailCode(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String code = body.get("code");
        boolean verified = emailVerificationService.verifyEmailCode(email, code);
        if (verified) {
            return ResponseEntity.ok("Correo verificado correctamente");
        }
        return ResponseEntity.badRequest().body("Código incorrecto o expirado");
    }
}
