package co.edu.uco.lilfac.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "co.edu.uco.lilfac")
@EnableJpaRepositories(basePackages = "co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa")
@EntityScan(basePackages = "co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.entity")
public class LilfacApplication {

	public static void main(String[] args) {
		SpringApplication.run(LilfacApplication.class, args);
	}

}
