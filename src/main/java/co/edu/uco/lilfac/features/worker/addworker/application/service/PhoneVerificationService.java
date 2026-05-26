package co.edu.uco.lilfac.features.worker.addworker.application.service;

public interface PhoneVerificationService {
    void sendSmsCode(String phoneNumber);
    boolean verifySmsCode(String phoneNumber, String code);
}
