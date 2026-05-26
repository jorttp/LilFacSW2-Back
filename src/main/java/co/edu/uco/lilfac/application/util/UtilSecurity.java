package co.edu.uco.lilfac.application.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public final class UtilSecurity {

    private UtilSecurity() {
        super();
    }

    public static String getCurrentUser() {
        try {
            Jwt jwt = (Jwt) SecurityContextHolder.getContext()
                    .getAuthentication().getPrincipal();
            return jwt.getClaim("preferred_username");
        } catch (Exception e) {
            return "anonymous";
        }
    }
}