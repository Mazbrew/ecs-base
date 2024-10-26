package Systems;

import static com.raylib.Raylib.DrawCircle;

import Components.ColorComponent;
import Components.PositionComponent;
import Enums.EntityType;
import Globals.Global;
import Utils.ComponentUtil;

public final class DrawSystem {

    public static void draw(String entityId, EntityType entityType){
        PositionComponent positionComponent = ComponentUtil.getPositionComponentWithId(entityId);
        ColorComponent colorComponent = ComponentUtil.getColorComponentWithId(entityId);

        int x = (int)positionComponent.getX();
        int y = (int)positionComponent.getY();

        switch(entityType){
            case CIRCLE:
                DrawCircle(x, y, Global.CIRCLE_SIZE, colorComponent.getColor());
                break;
        }
    }
}
