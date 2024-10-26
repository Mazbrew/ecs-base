package Entities;

import java.util.ArrayList;
import java.util.List;

import Enums.EntityType;
import Utils.IdUtil;

public final class EntityManager {
    private static final List<String> entityIdList = new ArrayList<>();

    private static final IEntity circleEntity = new CircleEntity();

    public static void createEntityWithCount(EntityType entity, int count) {
        for (int i = 0; i < count; i++) {
            addEntityToList(entity);
        }
    }

    public static void createEntity(EntityType entity) {
        addEntityToList(entity);
    }

    public static void createEntities(List<EntityType> entities) {
        for (EntityType entity : entities) {
            addEntityToList(entity);
        }
    }

    private static void addEntityToList(EntityType entity) {
        switch (entity) {
            case CIRCLE:
                entityIdList.add(circleEntity.getId());
                break;
        }
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
