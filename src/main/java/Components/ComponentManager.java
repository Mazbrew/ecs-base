package Components;

import java.util.HashMap;
import java.util.List;

import Entities.EntityManager;
import Enums.ComponentEnum;
import Enums.EntityType;
import Utils.IdUtil;

public final class ComponentManager {
    private static final HashMap<String, HashMap<ComponentEnum, IComponent>> entityComponentMap = new HashMap<>();

    public static void attachAllComponents() {
        for (String entityId : EntityManager.getEntityIdList()) {
            if (!entityComponentMap.containsKey(entityId)) {
                createComponentsForEntity(entityId);
            }
        }
    }

    public static void attachComponents(List<String> entityIds) {
        for (String entityId : entityIds) {
            createComponentsForEntity(entityId);
        }
    }

    public static void attachComponent(String entityId) {
        createComponentsForEntity(entityId);
    }

    public static void createComponentsForEntity(String entityId) {
        EntityType entityType = IdUtil.idStringToEntityType(entityId);
        HashMap<ComponentEnum, IComponent> componentMap = new HashMap<>();

        switch (entityType) {
            case CIRCLE:
                componentMap.put(ComponentEnum.POSITION, new PositionComponent());
                componentMap.put(ComponentEnum.COLOR, new ColorComponent());
                componentMap.put(ComponentEnum.DIRECTION, new DirectionComponent());
                componentMap.put(ComponentEnum.SPEED, new SpeedComponent());
                entityComponentMap.put(entityId, componentMap);
                break;
        }
    }

    public static <T extends IComponent> T getComponentFromEntityAndCast(String entityId, ComponentEnum component,
            Class<T> componentClass) {
        HashMap<ComponentEnum, IComponent> componentMap = entityComponentMap.get(entityId);

        if (componentMap != null) {
            return componentClass.cast(componentMap.get(component));
        }

        return null;
    }

    public static HashMap<ComponentEnum, IComponent> getComponentMap(String entityId) {
        return entityComponentMap.get(entityId);
    }
}
