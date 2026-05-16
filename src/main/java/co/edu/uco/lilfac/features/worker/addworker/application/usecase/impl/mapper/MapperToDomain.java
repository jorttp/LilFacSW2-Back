package co.edu.uco.lilfac.features.worker.addworker.application.usecase.impl.mapper;

import co.edu.uco.lilfac.application.util.UtilText;
import co.edu.uco.lilfac.application.util.UtilUUID;
import co.edu.uco.lilfac.features.worker.addworker.application.inputport.dto.AddWorkerDTO;
import co.edu.uco.lilfac.features.worker.addworker.application.usecase.domain.AddWorkerDomain;

public class MapperToDomain {
	
	private MapperToDomain () {
		super();
	}
	
	public static AddWorkerDomain toDomain(final AddWorkerDTO dto) {
        if (dto == null) {
            return null;
        }
        return new AddWorkerDomain(
                null,
                UtilText.applyDefault(dto.getName()),
                UtilUUID.applyDefault(dto.getIdType()),
                UtilText.applyDefault(dto.getIdNumber()),
                UtilText.applyDefault(dto.getPhoneNumber()),
                UtilText.applyDefault(dto.getMail()),
                UtilText.applyDefault(dto.getAddress())
        );
    }

}
