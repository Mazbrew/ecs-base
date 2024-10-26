package Systems;

import Components.DirectionComponent;
import Components.PositionComponent;
import Enums.EntityType;
import Globals.Global;
import Utils.ComponentUtil;

public class MovementManager {

    public static void updatePosition(String entityId, EntityType entityType) throws Exception {
        PositionComponent positionComponent = ComponentUtil.getPositionComponentWithId(entityId);
        DirectionComponent directionComponent = ComponentUtil.getDirectionComponentWithId(entityId);

        if (positionComponent != null) {
            float m = directionComponent.getDirection();

            float deltaX = (float) Math.cos(m);
            float deltaY = (float) Math.sin(m);

            float x = positionComponent.getX() + deltaX;
            float y = positionComponent.getY() + deltaY;

            if (x < 0 || x> Global.SCREEN_WIDTH) {
                directionComponent.setDirection((float) Math.PI - m);
            }

            if (y < 0 || y> Global.SCREEN_HEIGHT) {
                directionComponent.setDirection(-m);
            }

            switch (entityType) {
                case CIRCLE:
                    positionComponent.setX(x);
                    positionComponent.setY(y);
                    break;
            }

        } else {
            throw new Exception("Position Component Not Found");
        }
    }
}
