package co.edu.uco.lilfac.features.worker.addworker.application.service;

public interface EmailVerificationService {
    void sendEmailCode(String email);
    boolean verifyEmailCode(String email, String code);
}
