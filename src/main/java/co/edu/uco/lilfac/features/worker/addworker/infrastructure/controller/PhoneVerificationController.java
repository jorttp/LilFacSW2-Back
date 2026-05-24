package co.edu.uco.lilfac.features.worker.addworker.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.lilfac.features.worker.addworker.application.service.VerificationService;

@RestController
@RequestMapping("/api/v1/verification")
public class PhoneVerificationController {

    private final VerificationService verificationService;

    public PhoneVerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/sms/send")
    public ResponseEntity<String> sendSmsCode(@RequestParam String phoneNumber) {
        verificationService.sendSmsCode(phoneNumber);
        return ResponseEntity.ok("Código SMS enviado a " + phoneNumber);
    }

    @PostMapping("/sms/verify")
    public ResponseEntity<String> verifySmsCode(
            @RequestParam String phoneNumber,
            @RequestParam String code) {
        boolean verified = verificationService.verifySmsCode(phoneNumber, code);
        if (verified) {
            return ResponseEntity.ok("Número verificado correctamente");
        }
        return ResponseEntity.badRequest().body("Código incorrecto o expirado");
    }
}
