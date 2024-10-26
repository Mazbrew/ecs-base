package Systems;

import Components.DirectionComponent;
import Components.PositionComponent;
import Components.SpeedComponent;
import Enums.EntityType;
import Globals.Global;
import Utils.ComponentUtil;

public class MovementSystem {

    public static void updatePosition(String entityId, EntityType entityType) throws Exception {
        PositionComponent positionComponent = ComponentUtil.getPositionComponentWithId(entityId);
        DirectionComponent directionComponent = ComponentUtil.getDirectionComponentWithId(entityId);
        SpeedComponent speedComponent = ComponentUtil.getSpeedComponentWithId(entityId);

        if (positionComponent != null) {
            float m = directionComponent.getDirection();

            float deltaX = (float) Math.cos(m);
            float deltaY = (float) Math.sin(m);

            float x = positionComponent.getX() + deltaX * speedComponent.getSpeed();
            float y = positionComponent.getY() + deltaY * speedComponent.getSpeed();

            if(speedComponent.getSpeed() > 0.00f){
                speedComponent.setSpeed(speedComponent.getSpeed() - 0.01f);
            }else {
                speedComponent.setSpeed(0);
            }

            if (x < 0) {
                positionComponent.setX(0);
                directionComponent.setDirection((float) Math.PI - m);
            }

            if (x > Global.SCREEN_WIDTH) {
                positionComponent.setX(Global.SCREEN_WIDTH);
                directionComponent.setDirection((float) Math.PI - m);
            }

            if (y < 0) {
                positionComponent.setX(0);
                directionComponent.setDirection(-m);
            }

            if (y> Global.SCREEN_HEIGHT) {
                positionComponent.setX(Global.SCREEN_HEIGHT);
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
