package co.edu.uco.lilfac.features.worker.addworker.application.usecase.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.lilfac.features.worker.addworker.application.usecase.AddWorkerUseCase;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.domain.AddWorkerDomain;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.impl.mapper.MapperToEntity;
import co.edu.uco.lilfac.infrastructure.persistance.repository.WorkerRepository;
import co.edu.uco.lilfac.infrastructure.persistance.repository.entity.WorkerEntity;

@Service
public class AddWorkerUseCaseImpl implements AddWorkerUseCase{
	
	private WorkerRepository workerRepository;
	
	public AddWorkerUseCaseImpl (WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}

    @Override
    public Void execute(AddWorkerDomain data) {
        WorkerEntity workerEntity = MapperToEntity.toEntity(data);
        workerRepository.create(workerEntity);
        return null;
    }
}
