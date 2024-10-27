package Entities;

import java.util.ArrayList;
import java.util.List;

import Enums.EntityType;
import Utils.IdUtil;

public final class EntityManager {
    private static final List<String> entityIdList = new ArrayList<>();

    private static final IEntity circleEntity = new CircleEntity();

    public static List<String> createEntitiesWithCount(EntityType entity, int count) {
        List<String> entityIds = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String entityId = addEntityToList(entity);

            if(entityId != null){
                entityIds.add(entityId);
            }
        }

        return entityIds;
    }

    public static String createEntity(EntityType entity) {
        return addEntityToList(entity);
    }

    public static List<String> createEntities(List<EntityType> entities) {
        List<String> entityIds = new ArrayList<>();

        for (EntityType entity : entities) {
            String entityId = addEntityToList(entity);

            if(entityId != null){
                entityIds.add(entityId);
            }
        }

        return entityIds;
    }

    private static String addEntityToList(EntityType entity) {
        String entityId = null;

        switch (entity) {
            case CIRCLE:
                entityId = circleEntity.getId();
                entityIdList.add(entityId);
                break;
        }

        return entityId;
    }

    public static void removeEntity(EntityType entityType) {
        for (int i = 0; i < entityIdList.size(); i++) {
            if (entityType == IdUtil.idStringToEntityType(entityIdList.get(i))) {
                entityIdList.remove(i);
                break;
            }
        }
    }

    public static void removeEntityWithCount(EntityType entityType, int count) {
        int removedCount = 0;
        for (int i = entityIdList.size() - 1; i >= 0 && removedCount < count; i--) {
            if (entityType == IdUtil.idStringToEntityType(entityIdList.get(i))) {
                entityIdList.remove(i);
                removedCount++;
            }
        }
    }

    public static List<String> getEntityIdList() {
        return entityIdList;
    }
}
