package Entities;

import java.util.ArrayList;
import java.util.List;

import Enums.EntityType;

public final class EntityManager {
    private static final List<String> entityIdList = new ArrayList<>();
    
    private static final IEntity circleEntity = new CircleEntity();

    public static void createEntity(EntityType entity){
        addEntityToList(entity);
    }

    public static void createEntities(List<EntityType> entities){
        for(EntityType entity : entities){
            addEntityToList(entity);
        }
    }

    private static void addEntityToList(EntityType entity){
        switch(entity){
            case CIRCLE:
                entityIdList.add(circleEntity.getId());
                break;
        }
    }

    public static List<String> getEntityIdList() {
        return entityIdList;
    }
}
