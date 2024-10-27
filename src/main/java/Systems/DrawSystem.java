package Systems;

import static com.raylib.Jaylib.RAYWHITE;
import com.raylib.Jaylib.Rectangle;
import com.raylib.Jaylib.Vector2;

import static com.raylib.Raylib.DrawTexturePro;
import static com.raylib.Raylib.LoadTexture;

import com.raylib.Raylib.Texture;

import Components.BoundingBoxComponent;
import Components.ComponentManager;
import Components.PositionComponent;
import Enums.ComponentEnum;
import Enums.EntityType;
import Globals.Global;
import Utils.ComponentUtil;

public final class DrawSystem {
    private static final Texture circleTexture = LoadTexture(Global.CIRCLE_TEXTURE_PATH);
    private static final Rectangle circleSourceRectangle = new Rectangle(0,0, circleTexture.width(), circleTexture.height());
    private static final Vector2 circleOrigin = new Vector2(Global.CIRCLE_SIZE/2, Global.CIRCLE_SIZE);

    public static void draw(String entityId, EntityType entityType){
        PositionComponent positionComponent = ComponentUtil.getPositionComponentWithId(entityId);

        int x = (int)positionComponent.getX();
        int y = (int)positionComponent.getY();

        switch(entityType){
            case CIRCLE:
                BoundingBoxComponent boundingBoxComponent = ComponentManager.getComponentFromEntityAndCast(entityId, ComponentEnum.BOUNDING_BOX,
                        BoundingBoxComponent.class);

                DrawTexturePro(circleTexture, circleSourceRectangle, boundingBoxComponent.getBoundingBox(), circleOrigin, 0, RAYWHITE);
                break;
        }
    }
}
