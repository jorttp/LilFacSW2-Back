package co.edu.uco.lilfac.features.worker.addworker.application.usecase.impl.mapper;

import co.edu.uco.lilfac.application.util.UtilText;
import co.edu.uco.lilfac.application.util.UtilUUID;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.domain.AddWorkerDomain;
import co.edu.uco.lilfac.infrastructure.persistance.repository.entity.WorkerEntity;

public final class MapperToEntity {

	private MapperToEntity() {
        super();
    }

    public static WorkerEntity toEntity(final AddWorkerDomain addWorkerDomain) {
        if (addWorkerDomain == null) {
            return null;
        }
        return new WorkerEntity(
                UtilUUID.applyDefault(addWorkerDomain.getId()),
                UtilText.applyDefault(addWorkerDomain.getName()),
                UtilUUID.applyDefault(addWorkerDomain.getIdType()),
                UtilText.applyDefault(addWorkerDomain.getIdNumber()),
                UtilText.applyDefault(addWorkerDomain.getPhoneNumber()),
                UtilText.applyDefault(addWorkerDomain.getMail()),
                UtilText.applyDefault(addWorkerDomain.getAddress())
        );
    }

}