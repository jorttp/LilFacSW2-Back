package co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.mapper;

import co.edu.uco.lilfac.application.util.UtilText;
import co.edu.uco.lilfac.application.util.UtilUUID;
import co.edu.uco.lilfac.infrastructure.persistance.repository.entity.WorkerEntity;
import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.entity.WorkerJPAEntity;

public class MapperToJPAEntity {
	
	private MapperToJPAEntity() {
        super();
    }

    public static WorkerJPAEntity toJPAEntity(final WorkerEntity entity) {
        if (entity == null) {
            return null;
        }
        return new WorkerJPAEntity(
                UtilUUID.applyDefault(entity.getId()),
                UtilText.applyDefault(entity.getName()),
                UtilUUID.applyDefault(entity.getIdType()),
                UtilText.applyDefault(entity.getIdNumber()),
                UtilText.applyDefault(entity.getPhoneNumber()),
                UtilText.applyDefault(entity.getMail()),
                UtilText.applyDefault(entity.getAddress())
        );
    }
}