package co.edu.uco.lilfac.features.worker.addworker.application.inputport.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.lilfac.features.worker.addworker.application.inputport.AddWorkerInputPort;
import co.edu.uco.lilfac.features.worker.addworker.application.inputport.dto.AddWorkerDTO;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.AddWorkerUseCase;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.domain.AddWorkerDomain;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.impl.mapper.MapperToDomain;

@Service
@Transactional(rollbackFor = Exception.class)
public class AddWorkerInteractor implements AddWorkerInputPort {
	
	private AddWorkerUseCase useCase;
	public AddWorkerInteractor(AddWorkerUseCase useCase) {
		this.useCase = useCase;
	}

	@Override
	public Void execute(AddWorkerDTO data) {
		AddWorkerDomain domain = MapperToDomain.toDomain(data);
		return useCase.execute(domain);
	}

}

