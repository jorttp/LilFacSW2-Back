package co.edu.uco.lilfac.features.worker.addworker.application.service;

public interface VerificationService {
    void sendSmsCode(String phoneNumber);
    boolean verifySmsCode(String phoneNumber, String code);
}
