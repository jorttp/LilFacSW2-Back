package co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.lilfac.application.util.UtilText;
import co.edu.uco.lilfac.application.util.UtilUUID;
import co.edu.uco.lilfac.infrastructure.persistance.repository.entity.WorkerEntity;
import co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.entity.WorkerJPAEntity;

public class MapperToEntityFromJPAEntity {
	private MapperToEntityFromJPAEntity() {
        super();
    }

    public static WorkerEntity toEntity(final WorkerJPAEntity jpaEntity) {
        if (jpaEntity == null) {
            return null;
        }
        return new WorkerEntity(
                UtilUUID.applyDefault(jpaEntity.getId()),
                UtilText.applyDefault(jpaEntity.getName()),
                UtilUUID.applyDefault(jpaEntity.getIdType()),
                UtilText.applyDefault(jpaEntity.getIdNumber()),
                UtilText.applyDefault(jpaEntity.getPhoneNumber()),
                UtilText.applyDefault(jpaEntity.getMail()),
                UtilText.applyDefault(jpaEntity.getAddress())
        );
    }

    public static List<WorkerEntity> toEntityList(final List<WorkerJPAEntity> jpaEntities) {
        if (jpaEntities == null) {
            return new ArrayList<>();
        }
        return jpaEntities.stream()
                .map(MapperToEntityFromJPAEntity::toEntity)
                .collect(Collectors.toList());
    }
}
