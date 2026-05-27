package co.edu.uco.lilfac.infrastructure.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
	private String jwkSetUri;

	@Bean
	public JwtDecoder jwtDecoder() {
	    return NimbusJwtDecoder
	            .withJwkSetUri(jwkSetUri)
	            .build();
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> {})
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
            	.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            	.requestMatchers(HttpMethod.GET, "/api/v1/notifications").hasRole("ADMIN")
            	.requestMatchers("/api/v1/verification/**").permitAll()
            	.requestMatchers("/actuator/**").permitAll()
            	.requestMatchers(HttpMethod.GET, "/api/v1/parametros").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/workers")
                    .hasAnyRole("ADMIN", "CAJA", "BODEGA", "LOGISTICA")
                .requestMatchers(HttpMethod.POST, "/api/v1/workers").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwt -> jwt
                    .decoder(jwtDecoder())
                    .jwtAuthenticationConverter(jwtAuthenticationConverter())
                )
            );
        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            Map<String, Object> realmAccess = jwt.getClaim("realm_access");
            System.out.println(">>> realm_access: " + realmAccess);
            if (realmAccess == null) return List.of();

            Collection<String> roles = (Collection<String>) realmAccess.get("roles");
            System.out.println(">>> roles: " + roles);
            if (roles == null) return List.of();

            List<GrantedAuthority> authorities = roles.stream()
                    .map(role -> (GrantedAuthority) new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
            System.out.println(">>> authorities: " + authorities);
            return authorities;
        });
        return converter;
    }
}
