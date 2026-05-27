package co.edu.uco.lilfac.infrastructure.persistance.repository.adapter.sql.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.lilfac.application.util.UtilText;
import co.edu.uco.lilfac.application.util.UtilUUID;
import co.edu.uco.lilfac.infrastructure.persistance.repository.WorkerRepository;
import co.edu.uco.lilfac.infrastructure.persistance.repository.entity.WorkerEntity;
import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.WorkerJPARepository;
import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.entity.WorkerJPAEntity;
import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.mapper.MapperToEntityFromJPAEntity;
import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.mapper.MapperToJPAEntity;

@Repository
public class WorkerJPARepositoryAdapter implements WorkerRepository{
	
	private WorkerJPARepository repository;
	
	public WorkerJPARepositoryAdapter(WorkerJPARepository repository) {
		this.repository = repository;
	};
	

	@Override
	public void create(WorkerEntity entity) {
		WorkerJPAEntity jpaEntity = MapperToJPAEntity.toJPAEntity(entity);
		repository.save(jpaEntity);
		
	}

	@Override
	public void update(UUID id, WorkerEntity entity) {
		WorkerJPAEntity jpaEntity = MapperToJPAEntity.toJPAEntity(entity);
		repository.save(jpaEntity);
		
	}

	@Override
	public void delete(UUID id) {
		repository.deleteById(id);
		
	}

	@Override
    public List<WorkerEntity> findAll() {
        List<WorkerJPAEntity> jpaEntities = repository.findAll();
        return MapperToEntityFromJPAEntity.toEntityList(jpaEntities);
    }

	@Override
    public List<WorkerEntity> findByFilter(WorkerEntity filter) {
        List<WorkerJPAEntity> all = repository.findAll();
        return all.stream()
                .filter(jpa -> matchesFilter(jpa, filter))
                .map(MapperToEntityFromJPAEntity::toEntity)
                .collect(java.util.stream.Collectors.toList());
    }
	
	private boolean matchesFilter(WorkerJPAEntity jpa, WorkerEntity filter) {
	    if (filter == null) return true;

	    return matchesUUID(filter.getId(), jpa.getId())
	            && matchesText(filter.getName(), jpa.getName())
	            && matchesUUID(filter.getIdType(), jpa.getIdType())
	            && matchesText(filter.getIdNumber(), jpa.getIdNumber())
	            && matchesText(filter.getPhoneNumber(), jpa.getPhoneNumber())
	            && matchesText(filter.getMail(), jpa.getMail())
	            && matchesText(filter.getAddress(), jpa.getAddress());
	}

	private boolean matchesText(String filterValue, String jpaValue) {
	    return UtilText.isNullOrEmpty(filterValue) 
	            || jpaValue.toLowerCase().contains(filterValue.toLowerCase());
	}

	private boolean matchesUUID(UUID filterValue, UUID jpaValue) {
	    return UtilUUID.isNullOrDefault(filterValue) 
	            || filterValue.equals(jpaValue);
	}

	@Override
    public List<WorkerEntity> findById(UUID id) {
        return repository.findById(id)
                .map(MapperToEntityFromJPAEntity::toEntity)
                .map(List::of)
                .orElse(new ArrayList<>());
	}

	@Override
	public boolean existsByIdNumber(String idNumber) {
		return repository.existsByIdNumber(idNumber);
	}

}
