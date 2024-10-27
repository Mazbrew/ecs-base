package Utils;

import Components.BoundingBoxComponent;
import Components.ColorComponent;
import Components.ComponentManager;
import Components.DirectionComponent;
import Components.PositionComponent;
import Components.SizeComponent;
import Components.SpeedComponent;
import Enums.ComponentEnum;

public final class ComponentUtil {

    public static PositionComponent getPositionComponentWithId(String entityId){
        return (PositionComponent)ComponentManager.getComponentMap(entityId).get(ComponentEnum.POSITION);
    }

    public static SizeComponent getSizeComponentWithId(String entityId){
        return (SizeComponent)ComponentManager.getComponentMap(entityId).get(ComponentEnum.SIZE);
    }

    public static ColorComponent getColorComponentWithId(String entityId){
        return (ColorComponent)ComponentManager.getComponentMap(entityId).get(ComponentEnum.COLOR);
    }

    public static DirectionComponent getDirectionComponentWithId(String entityId){
        return (DirectionComponent)ComponentManager.getComponentMap(entityId).get(ComponentEnum.DIRECTION);
    }

    public static SpeedComponent getSpeedComponentWithId(String entityId){
        return (SpeedComponent)ComponentManager.getComponentMap(entityId).get(ComponentEnum.SPEED);
    }

    public static BoundingBoxComponent getBoundingBoxComponentWithId(String entityId){
        return (BoundingBoxComponent)ComponentManager.getComponentMap(entityId).get(ComponentEnum.BOUNDING_BOX);
    }
}
