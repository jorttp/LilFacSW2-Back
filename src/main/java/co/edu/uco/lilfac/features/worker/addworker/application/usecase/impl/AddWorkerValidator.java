package co.edu.uco.lilfac.features.worker.addworker.application.usecase.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import co.edu.uco.lilfac.application.exception.ValidationException;
import co.edu.uco.lilfac.application.util.UtilText;
import co.edu.uco.lilfac.application.util.UtilUUID;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.domain.AddWorkerDomain;
import co.edu.uco.lilfac.infrastructure.config.ParametersConfig;

@Component
public class AddWorkerValidator {

    private static final int NAME_MIN = 5;
    private static final int NAME_MAX = 100;
    private static final int ADDRESS_MIN = 8;
    private static final int ADDRESS_MAX = 200;

    private static final Pattern NAME_PATTERN =
            Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s'-]+$");
    private static final Pattern ID_NUMBER_PATTERN = Pattern.compile("^\\d{5,15}$");
    private static final Pattern NIT_PATTERN = Pattern.compile("^\\d{9}-\\d{1}$");
    private static final Pattern PHONE_CO_PATTERN = Pattern.compile("^\\+57[3]\\d{9}$");
    private static final Pattern PHONE_INT_PATTERN = Pattern.compile("^\\+[1-9]\\d{6,14}$");
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    private final ParametersConfig parametersConfig;

    public AddWorkerValidator(ParametersConfig parametersConfig) {
        this.parametersConfig = parametersConfig;
    }

    public void validate(AddWorkerDomain worker) {
        if (worker == null) {
            throw new ValidationException("Los datos del trabajador son obligatorios");
        }

        validateName(worker.getName());
        validateIdType(worker.getIdType());
        validateIdNumber(worker.getIdNumber());
        validatePhoneNumber(worker.getPhoneNumber());
        validateMail(worker.getMail());
        validateAddress(worker.getAddress());
    }

    public void validateMaxWorkers(int currentCount) {
        int max = parametersConfig.getMaxTrabajadores();
        if (max > 0 && currentCount >= max) {
            throw new ValidationException(
                    "Se alcanzó el límite máximo de trabajadores permitidos (" + max + ")"
            );
        }
    }

    private void validateName(String name) {
        if (UtilText.isNullOrEmpty(name)) {
            throw new ValidationException("El nombre completo es obligatorio");
        }
        if (name.length() < NAME_MIN || name.length() > NAME_MAX) {
            throw new ValidationException(
                    "El nombre debe tener entre " + NAME_MIN + " y " + NAME_MAX + " caracteres"
            );
        }
        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new ValidationException("El nombre solo puede contener letras, espacios, apóstrofes y guiones");
        }
    }

    private void validateIdType(java.util.UUID idType) {
        if (UtilUUID.isNullOrDefault(idType)) {
            throw new ValidationException("El tipo de documento es obligatorio");
        }
    }

    private void validateIdNumber(String idNumber) {
        if (UtilText.isNullOrEmpty(idNumber)) {
            throw new ValidationException("El número de documento es obligatorio");
        }
        if (!ID_NUMBER_PATTERN.matcher(idNumber).matches() && !NIT_PATTERN.matcher(idNumber).matches()) {
            throw new ValidationException(
                    "El número de documento debe tener entre 5 y 15 dígitos, o formato NIT (123456789-0)"
            );
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (UtilText.isNullOrEmpty(phoneNumber)) {
            throw new ValidationException("El número de teléfono es obligatorio");
        }
        if (!PHONE_CO_PATTERN.matcher(phoneNumber).matches()
                && !PHONE_INT_PATTERN.matcher(phoneNumber).matches()) {
            throw new ValidationException(
                    "El teléfono debe estar en formato internacional (ej: +573001234567)"
            );
        }
    }

    private void validateMail(String mail) {
        if (UtilText.isNullOrEmpty(mail)) {
            throw new ValidationException("El correo electrónico es obligatorio");
        }
        if (!EMAIL_PATTERN.matcher(mail).matches()) {
            throw new ValidationException("El correo electrónico no tiene un formato válido");
        }
    }

    private void validateAddress(String address) {
        if (UtilText.isNullOrEmpty(address)) {
            throw new ValidationException("La dirección es obligatoria");
        }
        if (address.length() < ADDRESS_MIN || address.length() > ADDRESS_MAX) {
            throw new ValidationException(
                    "La dirección debe tener entre " + ADDRESS_MIN + " y " + ADDRESS_MAX + " caracteres"
            );
        }
    }
}
