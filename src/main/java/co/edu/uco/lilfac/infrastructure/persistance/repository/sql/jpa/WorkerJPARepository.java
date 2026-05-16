package co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.entity.WorkerJPAEntity;

public interface WorkerJPARepository extends JpaRepository<WorkerJPAEntity, UUID>{

}
