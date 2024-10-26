package Utils;

import Components.ColorComponent;
import Components.ComponentManager;
import Components.DirectionComponent;
import Components.PositionComponent;
import Enums.ComponentEnum;

public final class ComponentUtil {

    public static PositionComponent getPositionComponentWithId(String entityId){
        return (PositionComponent)ComponentManager.getComponentMap(entityId).get(ComponentEnum.POSITION);
    }

    public static ColorComponent getColorComponentWithId(String entityId){
        return (ColorComponent)ComponentManager.getComponentMap(entityId).get(ComponentEnum.COLOR);
    }

    public static DirectionComponent getDirectionComponentWithId(String entityId){
        return (DirectionComponent)ComponentManager.getComponentMap(entityId).get(ComponentEnum.DIRECTION);
    }

}
