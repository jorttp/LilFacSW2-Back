package co.edu.uco.lilfac.features.worker.addworker.application.usecase.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.lilfac.application.exception.DuplicateResourceException;
import co.edu.uco.lilfac.application.util.UtilText;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.AddWorkerUseCase;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.domain.AddWorkerDomain;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.impl.mapper.MapperToEntity;
import co.edu.uco.lilfac.infrastructure.persistance.repository.WorkerRepository;
import co.edu.uco.lilfac.infrastructure.persistance.repository.entity.WorkerEntity;

@Service
public class AddWorkerUseCaseImpl implements AddWorkerUseCase {

    private final WorkerRepository workerRepository;
    private final AddWorkerValidator addWorkerValidator;

    public AddWorkerUseCaseImpl(WorkerRepository workerRepository, AddWorkerValidator addWorkerValidator) {
        this.workerRepository = workerRepository;
        this.addWorkerValidator = addWorkerValidator;
    }

    @Override
    public Void execute(AddWorkerDomain data) {
        addWorkerValidator.validate(data);
        addWorkerValidator.validateMaxWorkers(workerRepository.findAll().size());

        String idNumber = UtilText.applyDefault(data.getIdNumber());
        if (workerRepository.existsByIdNumber(idNumber)) {
            throw new DuplicateResourceException(
                    "Ya existe un trabajador registrado con el número de documento " + idNumber
            );
        }

        WorkerEntity workerEntity = MapperToEntity.toEntity(data);
        workerRepository.create(workerEntity);
        return null;
    }
}
