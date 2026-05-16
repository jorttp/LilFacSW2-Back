package co.edu.uco.lilfac.infrastructure.persistance.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.lilfac.infrastructure.persistance.repository.entity.WorkerEntity;

public interface WorkerRepository {
	void create (WorkerEntity entity);
	void update (UUID id, WorkerEntity entity);
	void delete (UUID id);
	List<WorkerEntity> findAll();
	List<WorkerEntity> findByFilter(WorkerEntity filter);
	List<WorkerEntity> findById(UUID id);

}
