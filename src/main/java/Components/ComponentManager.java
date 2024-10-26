package Components;

import java.util.HashMap;

import Entities.EntityManager;
import Enums.ComponentEnum;
import Enums.EntityType;
import Utils.IdUtil;

public final class ComponentManager {
    private static final HashMap<String, HashMap<ComponentEnum, IComponent>> entityComponentMap = new HashMap<>();

    public static void attachComponents() {
        if (!EntityManager.getEntityIdList().isEmpty()) {
            for (String entityId : EntityManager.getEntityIdList()) {
                if (!entityComponentMap.containsKey(entityId)) {
                    createComponents(entityId);
                }
            }
        }
    }

    public static void createComponents(String entityId) {
        EntityType entityType = IdUtil.idStringToEntityType(entityId);
        HashMap<ComponentEnum, IComponent> componentMap = new HashMap<>();

        switch(entityType){
            case CIRCLE:
                componentMap.put(ComponentEnum.POSITION ,new PositionComponent());
                componentMap.put(ComponentEnum.COLOR, new ColorComponent());
                componentMap.put(ComponentEnum.DIRECTION, new DirectionComponent());
                entityComponentMap.put(entityId, componentMap);
                break;
        }
    }

    public static HashMap<ComponentEnum, IComponent> getComponentMap(String entityId) {
        return entityComponentMap.get(entityId);
    }
}
