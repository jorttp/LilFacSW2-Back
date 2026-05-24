package co.edu.uco.lilfac.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "lilfac.parametros")
public class ParametersConfig {

    private int maxTrabajadores;
    private int intentosVerificacion;
    private int tiempoExpiracionOtp;
    private String moneda;
    private String pais;

    public int getMaxTrabajadores() { return maxTrabajadores; }
    public void setMaxTrabajadores(int maxTrabajadores) { this.maxTrabajadores = maxTrabajadores; }

    public int getIntentosVerificacion() { return intentosVerificacion; }
    public void setIntentosVerificacion(int intentosVerificacion) { this.intentosVerificacion = intentosVerificacion; }

    public int getTiempoExpiracionOtp() { return tiempoExpiracionOtp; }
    public void setTiempoExpiracionOtp(int tiempoExpiracionOtp) { this.tiempoExpiracionOtp = tiempoExpiracionOtp; }

    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}
