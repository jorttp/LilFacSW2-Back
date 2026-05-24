package co.edu.uco.lilfac.features.worker.addworker.application.service.impl;

import org.springframework.stereotype.Service;

import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;

import co.edu.uco.lilfac.features.worker.addworker.application.service.VerificationService;
import co.edu.uco.lilfac.infrastructure.config.TwilioConfig;

@Service
public class TwilioVerificationService implements VerificationService {

    private final TwilioConfig twilioConfig;

    public TwilioVerificationService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @Override
    public void sendSmsCode(String phoneNumber) {
        Verification.creator(
                twilioConfig.getVerifyServiceSid(),
                phoneNumber,
                "sms"
        ).create();
    }

    @Override
    public boolean verifySmsCode(String phoneNumber, String code) {
        VerificationCheck check = VerificationCheck.creator(
                twilioConfig.getVerifyServiceSid()
        ).setTo(phoneNumber).setCode(code).create();

        return "approved".equals(check.getStatus().toString());
    }
}
