package Systems;

import Entities.EntityManager;
import Enums.EntityType;
import Utils.IdUtil;

public final class SystemManager {

    public static void manage() {
        for (String entityId : EntityManager.getEntityIdList()) {
            EntityType entityType = IdUtil.idStringToEntityType(entityId);

            switch (entityType) {
                case CIRCLE:
                    try {
                        MovementSystem.updatePosition(entityId, entityType);
                        DrawSystem.draw(entityId, entityType);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
            }
        }
    }
}
